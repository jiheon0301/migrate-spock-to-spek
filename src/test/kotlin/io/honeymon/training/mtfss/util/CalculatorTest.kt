package io.honeymon.training.mtfss.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

/**
 *
 * @author jiheon.kim on 2019-01-08
 */
object CacluatorSpek : Spek({
    val calculator = Calculator()

    /**
     * SPEK 작성스타일 중  <a href="https://spekframework.org/specification/">Specification</a> 방식으로 작성했다.
     */
    describe("Calculator add") {
        describe("Kotlin Calculator: add") {
            var result = 0
            val left = 1
            val right = 2

            it("1 + 2") {
                result = calculator.add(left, right)
            }

            it("result is 3") {
                assertEquals(result, 3)
            }
        }

        describe("Kotlin Calculator: add dump") {
            class TestData(val left: Int, val right: Int, val result: Int)

            it("Test") {
                listOf(
                        TestData(1, 3, 4),
                        TestData(4, 6, 10),
                        TestData(49, 51, 100),
                        TestData(50, 51, 101)
                ).forEach { assertEquals(it.result, calculator.add(it.left, it.right)) }
            }
        }
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(value = ["0, 1, 1", "1, 2, 3", "49, 51, 100", "1, 100, 101"])
    fun testAdd(left: Int, right: Int, expectedResult: Int) {
        assertEquals(expectedResult, calculator.add(left, right))
    }
})