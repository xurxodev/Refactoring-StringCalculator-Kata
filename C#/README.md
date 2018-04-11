# C# initial implementation

## Tests

```C#
public class StringCalculatorShould
    {
        [Fact]
        public void return_zero_if_input_is_empty()
        {
            int expectedResult = 0;

            StringCalculator calculator = new StringCalculator();

            int result = calculator.Add("");

            Assert.Equal(expectedResult, result);
        }

        [Fact]
        public void return_one_if_input_is_one()
        {
            int expectedResult = 1;

            StringCalculator calculator = new StringCalculator();

            int result = calculator.Add("1");

            Assert.Equal(expectedResult, result);
        }

        [Fact]
        public void return_three_if_input_is_one_and_two()
        {
            int expectedResult = 3;

            StringCalculator calculator = new StringCalculator();

            int result = calculator.Add("1,2");

            Assert.Equal(expectedResult, result);
        }

        [Fact]
        public void return_fifteen_if_input_is_from_one_to_five()
        {
            int expectedResult = 15;

            StringCalculator calculator = new StringCalculator();

            int result = calculator.Add("1,2,3,4,5");

            Assert.Equal(expectedResult, result);
        }

        [Fact]
        public void return_two_if_input_is_two_and_thousand_and_one()
        {
            int expectedResult = 2;

            StringCalculator calculator = new StringCalculator();

            int result = calculator.Add("2,1001");

            Assert.Equal(expectedResult, result);
        }

        [Fact]
        public void throw_exception_if_input_contains_negative_number()
        {
            Exception ex = Assert.Throws<Exception>(() =>
            {
                StringCalculator calculator = new StringCalculator();

                int result = calculator.Add("2,-5");
            });

            Assert.Equal("negatives not allowed", ex.Message);
        }
    }
```

## Simple StringCalculator

```c#
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
```
