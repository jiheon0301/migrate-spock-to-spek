package io.honeymon.training.mtfss.domain.repository;

import io.honeymon.training.mtfss.domain.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author jiheon.kim on 2019-01-08
 */
public class InMemoryUserRepository implements UserRepository {
    Map<String, User> repository = new HashMap<>();

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(repository.get(username));
    }

    @Override
    public User save(User user) {
        repository.put(user.getUsername(), user);
        return user;
    }
}
