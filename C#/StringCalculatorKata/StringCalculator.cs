using StringCalculatorKata.Boundaries;
using System;
using System.Collections.Generic;

namespace StringCalculatorKata
{
    public class StringCalculator
    {
        INumberExtractor numberExtractor;
        INumberRemover numberRemover;
        INumberValidator numberValidator;

        public StringCalculator(INumberExtractor numberExtractor,
                                INumberRemover numberRemover,
                                INumberValidator numberValidator)
        {
            this.numberExtractor = numberExtractor;
            this.numberRemover = numberRemover;
            this.numberValidator = numberValidator;
        }

        public int Add(String input)
        {
            List<int> allNumbers = numberExtractor.Extract(input);

            List<int> numbersWithoutIgnored = numberRemover.RemoveNumbersToIgnore(allNumbers);

            numberValidator.Validate(numbersWithoutIgnored);

            return SumNumbers(numbersWithoutIgnored);
        }

        private int SumNumbers(List<int> numbers)
        {
            int sum = 0;
            foreach (int num in numbers)
            {
                sum += num;
            }
            return sum;
        }
    }
}
