package com.tutorial.graphql.graphqltutorial.service.impl;

import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.repository.UserRepository;
import com.tutorial.graphql.graphqltutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<User> findAll(long cursor, Pageable pageable) {
        return repository.findAll(cursor, pageable);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<User> findAllByReviewIds(Collection<Long> ids) {
        return repository.findAllByReviewIds(ids);
    }

    @Override
    public boolean hasWithIdBefore(long id) {
        return repository.existsByIdIsBefore(id);
    }

    @Override
    public boolean hasWithIdAfter(long id) {
        return repository.existsByIdIsAfter(id);
    }
}
