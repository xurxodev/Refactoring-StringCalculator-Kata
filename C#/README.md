# Java initial implementation

## Tests

```java
public class StringCalculatorShould {
    @Test
    public void return_zero_if_input_is_empty() throws Exception {
        int expectedResult = 0;

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("");

        assertThat(result, is(expectedResult));
    }

    @Test
    public void return_one_if_input_is_one() throws Exception {
        int expectedResult = 1;

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1");

        assertThat(result, is(expectedResult));
    }

    @Test
    public void return_three_if_input_is_one_and_two() throws Exception {
        int expectedResult = 3;

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1,2");

        assertThat(result, is(expectedResult));
    }

    @Test
    public void return_fifteen_if_input_is_from_one_to_five() throws Exception {
        int expectedResult = 15;

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1,2,3,4,5");

        assertThat(result, is(expectedResult));
    }

    @Test
    public void return_two_if_input_is_two_and_thousand_and_one() throws Exception {
        int expectedResult = 2;

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("2,1001");

        assertThat(result, is(expectedResult));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throw_exception_if_input_contains_negative_number() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("negatives not allowed");

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("2,-5");
    }
}
```

## Simple StringCalculator

```java
public class StringCalculator {
    private int DEFAULT_RESULT = 0;

    public int add(String input) throws Exception {
        if (input=="")
        {
            return DEFAULT_RESULT;
        }
        if (input.contains(","))
        {
            return handleMultiple(input);
        }
        return parseSingle(input);
    }

    private static int parseSingle(String input) throws Exception {
        int number = Integer.parseInt(input);

        if (number > 1000)
            return 0;
        else if (number < 0)
            throw new Exception("negatives not allowed");
        else
            return number;

    }

    private int handleMultiple(String input) throws Exception {
        int sum = 0;

        String[] numbers = input.split(",");

        for (String number:numbers) {
            sum += parseSingle(number);
        }

        return sum;
    }
}
```
