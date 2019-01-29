package io.honeymon.training.mtfss.domain.repository;

import io.honeymon.training.mtfss.domain.entity.User;

import java.util.Optional;

/**
 * @author jiheon.kim on 2019-01-08
 */
public interface UserRepository {
    Optional<User> findByUsername(String username);

    User save(User user);
}
