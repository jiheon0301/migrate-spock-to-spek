package io.honeymon.training.mtfss.service

import io.honeymon.training.mtfss.domain.entity.User
import io.honeymon.training.mtfss.domain.repository.InMemoryUserRepository
import io.honeymon.training.mtfss.domain.repository.UserRepository
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

        Scenario("Create user") {
            val username = "Tester"
            lateinit var user: User

            When("UserService.create") {
                user = userService.createUser(username)
            }

            Then("created user.username is equals to username") {
                assertThat(user.username).isEqualTo(username)
            }

        }
    }
})