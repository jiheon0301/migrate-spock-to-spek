package io.honeymon.training.mtfss.service

import io.honeymon.training.mtfss.domain.entity.User
import io.honeymon.training.mtfss.domain.repository.InMemoryUserRepository
import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

/**
 *
 * @author jiheon.kim on 2019-01-11
 */
object UserServiceSpek : Spek({
    Feature("UserService") {
        val userRepository = InMemoryUserRepository()
        val userService = UserService(userRepository)

        /**
         * SPEK 작성스타일 중 <a href="https://spekframework.org/gherkin/">Gherkin</a> 으로 작성했다.
         * Given, When, Then 조건절에 대해서 별도로 선언해야하는 부분과 변수에 대한 접근이 번거로운 문제가 있어서 사용하기 싫어진다.
         */
        Scenario("Create user") {
            lateinit var username: String
            lateinit var user: User

            Given("Variable set") {
                username = "Tester"
            }

            When("UserService.create") {
                user = userService.createUser(username)
            }

            Then("created user.username is equals to username") {
                assertThat(user.username).isEqualTo(username)
            }
        }
    }
})