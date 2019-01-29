package io.honeymon.training.mtfss.service;

import io.honeymon.training.mtfss.common.exception.UserNotFoundException;
import io.honeymon.training.mtfss.domain.entity.User;
import io.honeymon.training.mtfss.domain.repository.UserRepository;

/**
 * @author jiheon.kim on 2019-01-08
 */
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    public User createUser(String username) {
        return repository.save(User.of(username));
    }
}
