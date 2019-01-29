package io.honeymon.training.mtfss.service;

import io.honeymon.training.mtfss.domain.entity.User;
import io.honeymon.training.mtfss.domain.repository.InMemoryUserRepository;
import io.honeymon.training.mtfss.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jiheon.kim on 2019-01-11
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {
    private UserRepository userRepository;
    private UserService userService;

    @BeforeAll
    public void setUp() {
        userRepository = new InMemoryUserRepository();
        userService = new UserService(userRepository);
    }

    @Test
    public void testCreateUser() {
        //given
        String username = "Tester";
        //when
        User user = userService.createUser(username);
        //then
        assertThat(user.getUsername()).isEqualTo(username);
    }
}
