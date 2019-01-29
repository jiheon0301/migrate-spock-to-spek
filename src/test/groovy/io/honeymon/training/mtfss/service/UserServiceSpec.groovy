package io.honeymon.training.mtfss.service

import io.honeymon.training.mtfss.domain.entity.User
import io.honeymon.training.mtfss.domain.repository.InMemoryUserRepository
import io.honeymon.training.mtfss.domain.repository.UserRepository
import spock.lang.Specification

/**
 *
 * @author jiheon.kim on 2019-01-11
 */
class UserServiceSpec extends Specification {
    UserService userService
    UserRepository userRepository

    def setup() {
        userRepository = new InMemoryUserRepository()
        userService = new UserService(userRepository)
    }

    def "Spock User create"() {
        given:
            def username = "Tester"
        when:
            User user = userService.createUser(username)
        then:
            user.getUsername() == username
            user.createdDatetime == null
    }
}