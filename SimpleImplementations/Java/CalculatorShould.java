package com.xurxodev.refactoringstringcalculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class CalculatorShould {
    @Test
    public void return_zero_if_input_is_empty() {
        int expectedResult = 0;

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("");

        assertThat(result, is(expectedResult));
    }

    @Test
    public void return_one_if_input_is_one() {
        int expectedResult = 1;

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1");

        assertThat(result, is(expectedResult));
    }

    @Test
    public void return_three_if_input_is_one_and_two() {
        int expectedResult = 3;

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1,2");

        assertThat(result, is(expectedResult));
    }
}