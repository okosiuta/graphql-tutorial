package com.tutorial.graphql.graphqltutorial.api.impl;

import com.tutorial.graphql.graphqltutorial.api.UserApi;
import com.tutorial.graphql.graphqltutorial.custom.exception.ResourceNotFoundException;
import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.service.UserService;
import graphql.relay.DefaultEdge;
import graphql.relay.DefaultPageInfo;
import graphql.relay.Edge;
import graphql.relay.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.tutorial.graphql.graphqltutorial.constant.ErrorMessage.RESOURCE_NOT_FOUND;
import static com.tutorial.graphql.graphqltutorial.constant.GeneralConstant.USERS;
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
public class UserApiImpl implements UserApi {

    private final UserService userService;

    @Override
    public User getById(long id) {
        return userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, USERS, id)));
    }

    @Override
    public List<User> getAll() {
        return userService.findAll();
    }

    @Override
    public User create(User user) {
        return userService.save(user);
    }

    @Override
    public Page<User> getUserPageResult(int page, int size) {
        return userService.findAll(of(page, size));
    }

    @Override
    public ExtendedConnection<User> getUserConnection(int first, String after) {
        var page = getUsersByCursor(after, of(0, first));
        List<Edge<User>> edges = page.get()
                .map(user -> new DefaultEdge<>(user, from(user.getId())))
                .collect(Collectors.toList());

        return new ExtendedConnection<>(edges, createPageInfo(edges), page.getTotalElements());
    }

    private Page<User> getUsersByCursor(String after, Pageable pageable) {
        return isBlank(after)
                ? userService.findAll(pageable)
                : userService.findAll(from(after), pageable);
    }

    private PageInfo createPageInfo(List<Edge<User>> edges) {
        var firstElement = firstElement(edges);
        var lastElement = lastElement(edges);

        return new DefaultPageInfo(getCursor(firstElement), getCursor(lastElement), hasUsersWithIdBefore(firstElement),
                hasUsersWithIdAfter(lastElement));
    }

    private boolean hasUsersWithIdBefore(Edge<User> edge) {
        return nonNull(edge) && userService.hasWithIdBefore(edge.getNode().getId());
    }

    private boolean hasUsersWithIdAfter(Edge<User> edge) {
        return nonNull(edge) && userService.hasWithIdAfter(edge.getNode().getId());
    }
}
