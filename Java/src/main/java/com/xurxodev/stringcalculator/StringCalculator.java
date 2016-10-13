package com.xurxodev.stringcalculator;

import com.xurxodev.stringcalculator.exception.ValidatorException;

import java.util.List;

public class StringCalculator {

    NumberExtractor numberExtractor;
    NumberRemover numberRemover;
    NumberValidator numberValidator;

    public StringCalculator(NumberExtractor numberExtractor,
                            NumberRemover numberRemover,
                            NumberValidator numberValidator){
        this.numberExtractor = numberExtractor;
        this.numberRemover = numberRemover;
        this.numberValidator = numberValidator;
    }

    public int add(String input) throws ValidatorException {
        List<Integer> allNumbers = numberExtractor.extract(input);

        List<Integer> numbersWithoutIgnored = numberRemover.removeNumbersToIgnore(allNumbers);

        numberValidator.validate(numbersWithoutIgnored);

        return sumNumbers(numbersWithoutIgnored);
    }

    private int sumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }

    public interface NumberExtractor {
        List<Integer> extract(String numbers);
    }

    public interface NumberRemover {
        List<Integer> removeNumbersToIgnore(List<Integer> numbers);
    }

    public interface NumberValidator {
        void validate(List<Integer> numbers) throws ValidatorException;
    }
}
