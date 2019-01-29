package io.honeymon.training.mtfss.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jiheon.kim on 2019-01-07
 */
public class CalculatorTest {
    Calculator calculator = new Calculator();;


    @Test
    void testAdd() {
        //given
        int left = 1;
        int right = 2;

        //when
        int result = calculator.add(left, right);

        // then
        assertEquals(result, 3);
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(value = {"0, 1, 1", "1, 2, 3", "49, 51, 100", "1, 100, 101"})
    public void testAdd(int left, int right, int expectedResult) {
        System.out.println(String.format(""));
        assertEquals(expectedResult, calculator.add(left, right));
    }

}
