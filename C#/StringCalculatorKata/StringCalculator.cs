using System;

namespace StringCalculatorKata
{
    public class StringCalculator
    {
        private int DEFAULT_RESULT = 0;

        public int Add(string input)
        {
            if (string.IsNullOrEmpty(input))
            {
                return DEFAULT_RESULT;
            }
            if (input.Contains(","))
            {
                return HandleMultiple(input);
            }
            return ParseSingle(input);
        }

        private int ParseSingle(String input)
        {
            int number = int.Parse(input);

            if (number > 1000)
                return 0;
            else if (number < 0)
                throw new Exception("negatives not allowed");
            else
                return number;

        }

        private int HandleMultiple(String input)
        {
            int sum = 0;

            String[] numbers = input.Split(',');

            foreach (String number in numbers)
            {
                sum += ParseSingle(number);
            }

            return sum;
        }
    }
}
