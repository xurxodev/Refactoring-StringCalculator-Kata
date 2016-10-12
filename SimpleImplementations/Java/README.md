# Java initial implementation

## Tests

```java
public class StringCalculatorShould {
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
```

## Simple StringCalculator

```java

public class StringCalculator {
private int DEFAULT_RESULT = 0;

public int add(String numbers)
{
if (numbers=="")
{
return DEFAULT_RESULT;
}
if (numbers.contains(","))
{
return handleMultiple(numbers);
}
return parseSingle(numbers);
}

private static int parseSingle(String input)
{
return Integer.parseInt(input);
}

private int handleMultiple(String input)
{
String[] numbers = input.split(",");
return add(numbers[0]) + add(numbers[1]);
}
}
```