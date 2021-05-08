package com.tutorial.graphql.graphqltutorial.api.impl;

import com.tutorial.graphql.graphqltutorial.api.BookApi;
import com.tutorial.graphql.graphqltutorial.custom.exception.ResourceNotFoundException;
import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.service.AuthorService;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import graphql.relay.DefaultEdge;
import graphql.relay.DefaultPageInfo;
import graphql.relay.Edge;
import graphql.relay.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.tutorial.graphql.graphqltutorial.constant.ErrorMessage.RESOURCE_NOT_FOUND;
import static com.tutorial.graphql.graphqltutorial.constant.GeneralConstant.BOOKS;
import static com.tutorial.graphql.graphqltutorial.util.ConnectionUtils.from;
import static com.tutorial.graphql.graphqltutorial.util.ConnectionUtils.getCursor;
import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.util.CollectionUtils.firstElement;
import static org.springframework.util.CollectionUtils.lastElement;

@Service
@RequiredArgsConstructor
public class BookApiImpl implements BookApi {

    private final BookService bookService;
    private final AuthorService authorService;

    @Override
    public Book getById(long id) {
        return bookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, BOOKS, id)));
    }

    @Override
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @Override
    public Book create(Book book) {
        return bookService.save(book);
    }

    @Override
    public Book addBookAuthors(long bookId, Set<Long> authorIds) {
        var book = getById(bookId);
        var authors = authorService.findAllByIds(authorIds);

        book.getAuthors().addAll(authors);

        return bookService.save(book);
    }

    @Override
    public Page<Book> getBookPageResult(int page, int size) {
        return bookService.findAll(of(page, size));
    }

    @Override
    public ExtendedConnection<Book> getBookConnection(int first, String after) {
        var page = getBooksByCursor(after, of(0, first));
        List<Edge<Book>> edges = page.get()
                .map(book -> new DefaultEdge<>(book, from(book.getId())))
                .collect(Collectors.toList());

        return new ExtendedConnection<>(edges, createPageInfo(edges), page.getTotalElements());
    }

    private Page<Book> getBooksByCursor(String after, Pageable pageable) {
        return isBlank(after)
                ? bookService.findAll(pageable)
                : bookService.findAll(from(after), pageable);
    }

    private PageInfo createPageInfo(List<Edge<Book>> edges) {
        var firstElement = firstElement(edges);
        var lastElement = lastElement(edges);

        return new DefaultPageInfo(getCursor(firstElement), getCursor(lastElement), hasBooksWithIdBefore(firstElement),
                hasBooksWithIdAfter(lastElement));
    }

    private boolean hasBooksWithIdBefore(Edge<Book> edge) {
        return nonNull(edge) && bookService.hasWithIdBefore(edge.getNode().getId());
    }

    private boolean hasBooksWithIdAfter(Edge<Book> edge) {
        return nonNull(edge) && bookService.hasWithIdAfter(edge.getNode().getId());
    }
}
