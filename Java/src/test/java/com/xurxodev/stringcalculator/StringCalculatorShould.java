package com.xurxodev.stringcalculator;

import com.xurxodev.stringcalculator.rule.NegativeNumberValidateRule;
import com.xurxodev.stringcalculator.rule.NumberGreaterThanIgnoredRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StringCalculatorShould {
    @Test
    public void return_zero_if_input_is_empty() throws Exception {
        int expectedResult = 0;

        StringCalculator calculator = givenAStringCalculator();

        int result = calculator.add("");

        assertThat(result, is(expectedResult));
    }

    @Test
    public void return_one_if_input_is_one() throws Exception {
        int expectedResult = 1;

        StringCalculator calculator = givenAStringCalculator();

        int result = calculator.add("1");

        assertThat(result, is(expectedResult));
    }

    @Test
    public void return_three_if_input_is_one_and_two() throws Exception {
        int expectedResult = 3;

        StringCalculator calculator = givenAStringCalculator();

        int result = calculator.add("1,2");

        assertThat(result, is(expectedResult));
    }

    @Test
    public void return_fifteen_if_input_is_from_one_to_five() throws Exception {
        int expectedResult = 15;

        StringCalculator calculator = givenAStringCalculator();

        int result = calculator.add("1,2,3,4,5");

        assertThat(result, is(expectedResult));
    }

    @Test
    public void return_two_if_input_is_two_and_thousand_and_one() throws Exception {
        int expectedResult = 2;

        StringCalculator calculator = givenAStringCalculator();

        int result = calculator.add("2,1001");

        assertThat(result, is(expectedResult));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throw_exception_if_input_contains_negative_number() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Negatives not allowed");

        StringCalculator calculator = givenAStringCalculator();

        int result = calculator.add("2,-5");
    }

    private StringCalculator givenAStringCalculator() {
        StringCalculator.NumberExtractor numberExtractor = new NumberExtractorFromCommaSeparatedString();
        StringCalculator.NumberRemover numberRemover = createNumberRemover();
        StringCalculator.NumberValidator numberValidator = createNumberValidator();

        return new StringCalculator(numberExtractor,numberRemover,numberValidator);
    }

    private StringCalculator.NumberRemover createNumberRemover(){
        final NumberRemoverByIgnoredRules.IgnoredRule ignoredRule = new NumberGreaterThanIgnoredRule(1000);

        List<NumberRemoverByIgnoredRules.IgnoredRule> ignoredRules = new ArrayList<>();

        ignoredRules.add(ignoredRule);

        return new NumberRemoverByIgnoredRules(ignoredRules);
    }

    private StringCalculator.NumberValidator createNumberValidator(){
        final NumberValidatorByValidateRules.ValidateRule validateRule = new NegativeNumberValidateRule();

        List<NumberValidatorByValidateRules.ValidateRule> validateRules = new ArrayList<>();

        validateRules.add(validateRule);

        return new NumberValidatorByValidateRules(validateRules);
    }
}