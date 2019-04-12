package io.honeymon.training.mtfss.service

import io.honeymon.training.mtfss.domain.entity.User
import io.honeymon.training.mtfss.domain.repository.InMemoryUserRepository
import io.honeymon.training.mtfss.domain.repository.UserRepository
import spock.lang.Specification

/**
 *
 * @author jiheon.kim on 2019-01-11
 *
 * ... 테스트를 작성하기는 SPOCK이 용이하다.
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
            user.createdDatetime == null // User 클래스에서 createdDatetime 이라는 필드가 사라졌지만 컴파일 에러가 발생하지 않아 수정하는 것을 놓칠 수 있다.
    }
}