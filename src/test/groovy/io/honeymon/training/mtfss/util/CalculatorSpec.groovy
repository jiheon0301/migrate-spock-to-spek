package io.honeymon.training.mtfss.util


import spock.lang.Specification

/**
 * SPOCK 1.2 는 junit4 기반이기 때문에 jUnit5 에서 실행하기 위해서는 junit-vintage-engine 모듈이 필요하다.
 * @author jiheon.kim on 2019-01-08
 */
class CalculatorSpec extends Specification {
    def calculator = new Calculator()

    def "Spock Calculator: add"() {
        given:
            def left = 5
            def right = 6
        when:
            def result = calculator.add(left, right)
        then:
            result == 11
    }

    def "Spock Calculator: add where"() {
        expect:
            calculator.add(left, right) == result
        where:
            left | right | result
            1    | 9     | 10
            4    | 6     | 10
            6    | 4     | 10
            19   | 21    | 40
            49   | 51    | 100
            50   | 51    | 101
    }
}
