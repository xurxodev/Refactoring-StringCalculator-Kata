package com.xurxodev.refactoringstringcalculator;

import static java.lang.Integer.parseInt;

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
