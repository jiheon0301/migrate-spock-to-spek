package io.honeymon.training.mtfss.common.exception;

/**
 * @author jiheon.kim on 2019-01-08
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super(String.format("Not found User(username: %s)", username));
    }
}
