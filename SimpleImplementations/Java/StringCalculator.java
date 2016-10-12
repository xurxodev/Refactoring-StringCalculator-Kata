package com.xurxodev.refactoringstringcalculator;

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
