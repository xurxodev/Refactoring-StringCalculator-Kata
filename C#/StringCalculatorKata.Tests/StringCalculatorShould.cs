using StringCalculatorKata.Boundaries;
using StringCalculatorKata.Errors;
using StringCalculatorKata.Rules;
using System;
using System.Collections.Generic;
using Xunit;

namespace StringCalculatorKata.Tests
{
    public class StringCalculatorShould
    {
        [Fact]
        public void return_zero_if_input_is_empty()
        {
            int expectedResult = 0;

            StringCalculator calculator = GivenAStringCalculator(); 

            int result = calculator.Add("");

            Assert.Equal(expectedResult, result);
        }

        [Fact]
        public void return_one_if_input_is_one()
        {
            int expectedResult = 1;

            StringCalculator calculator = GivenAStringCalculator();

            int result = calculator.Add("1");

            Assert.Equal(expectedResult, result);
        }

        [Fact]
        public void return_three_if_input_is_one_and_two()
        {
            int expectedResult = 3;

            StringCalculator calculator = GivenAStringCalculator();

            int result = calculator.Add("1,2");

            Assert.Equal(expectedResult, result);
        }

        [Fact]
        public void return_fifteen_if_input_is_from_one_to_five()
        {
            int expectedResult = 15;

            StringCalculator calculator = GivenAStringCalculator();

            int result = calculator.Add("1,2,3,4,5");

            Assert.Equal(expectedResult, result);
        }

        [Fact]
        public void return_two_if_input_is_two_and_thousand_and_one()
        {
            int expectedResult = 2;

            StringCalculator calculator = GivenAStringCalculator();

            int result = calculator.Add("2,1001");

            Assert.Equal(expectedResult, result);
        }

        [Fact]
        public void throw_exception_if_input_contains_negative_number()
        {
            NegativeNumbersNotAllowedException ex = Assert.Throws<NegativeNumbersNotAllowedException>(() =>
            {
                StringCalculator calculator = GivenAStringCalculator();

                int result = calculator.Add("2,-5");
            });

            Assert.Equal("Negatives not allowed", ex.Message);
        }

        private StringCalculator GivenAStringCalculator()
        {
            INumberExtractor numberExtractor = new NumberExtractorFromCommaSeparatedString();
            INumberRemover numberRemover = createNumberRemover();
            INumberValidator numberValidator = createNumberValidator();

            return new StringCalculator(numberExtractor, numberRemover, numberValidator);
        }

        private INumberRemover createNumberRemover()
        {
            IIgnoreRule ignoredRule = new NumberGreaterThanIgnoredRule(1000);

            List<IIgnoreRule> ignoredRules = new List<IIgnoreRule>();

            ignoredRules.Add(ignoredRule);

            return new NumberRemoverByIgnoredRules(ignoredRules);
        }

        private INumberValidator createNumberValidator()
        {
            IValidateRule validateRule = new NegativeNumberValidateRule();

            List<IValidateRule> validateRules = new List<IValidateRule>();

            validateRules.Add(validateRule);

            return new NumberValidatorByValidateRules(validateRules);
        }
    }
}
