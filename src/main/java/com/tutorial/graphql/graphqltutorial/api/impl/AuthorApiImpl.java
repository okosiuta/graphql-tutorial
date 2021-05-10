package com.tutorial.graphql.graphqltutorial.api.impl;

import com.tutorial.graphql.graphqltutorial.api.AuthorApi;
import com.tutorial.graphql.graphqltutorial.custom.exception.ResourceNotFoundException;
import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.publisher.AbstractPublisher;
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
import static com.tutorial.graphql.graphqltutorial.constant.GeneralConstant.AUTHORS;
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
public class AuthorApiImpl implements AuthorApi {

    private final AbstractPublisher<Author> publisher;
    private final AuthorService authorService;
    private final BookService bookService;

    @Override
    public Author getById(long id) {
        return authorService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, AUTHORS, id)));
    }

    @Override
    public List<Author> getAll() {
        return authorService.findAll();
    }

    @Override
    public Author create(Author author) {
        var createdAuthor = authorService.save(author);

        publisher.publish(createdAuthor);
        return createdAuthor;
    }

    @Override
    public Author addAuthorBooks(long authorId, Set<Long> bookIds) {
        var author = getById(authorId);
        var books = bookService.findAllByIds(bookIds);

        author.getBooks().addAll(books);

        return authorService.save(author);
    }

    @Override
    public Page<Author> getAuthorPageResult(int page, int size) {
        return authorService.findAll(of(page, size));
    }

    @Override
    public ExtendedConnection<Author> getAuthorConnection(int first, String after) {
        var page = getAuthorsByCursor(after, of(0, first));
        List<Edge<Author>> edges = page.get()
                .map(author -> new DefaultEdge<>(author, from(author.getId())))
                .collect(Collectors.toList());

        return new ExtendedConnection<>(edges, createPageInfo(edges), page.getTotalElements());
    }

    private Page<Author> getAuthorsByCursor(String after, Pageable pageable) {
        return isBlank(after)
                ? authorService.findAll(pageable)
                : authorService.findAll(from(after), pageable);
    }

    private PageInfo createPageInfo(List<Edge<Author>> edges) {
        var firstElement = firstElement(edges);
        var lastElement = lastElement(edges);

        return new DefaultPageInfo(getCursor(firstElement), getCursor(lastElement), hasAuthorsWithIdBefore(firstElement),
                hasAuthorsWithIdAfter(lastElement));
    }

    private boolean hasAuthorsWithIdBefore(Edge<Author> edge) {
        return nonNull(edge) && authorService.hasWithIdBefore(edge.getNode().getId());
    }

    private boolean hasAuthorsWithIdAfter(Edge<Author> edge) {
        return nonNull(edge) && authorService.hasWithIdAfter(edge.getNode().getId());
    }
}
