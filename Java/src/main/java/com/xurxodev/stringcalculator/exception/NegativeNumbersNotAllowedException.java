package com.xurxodev.stringcalculator.exception;

public class NegativeNumbersNotAllowedException extends ValidatorException {
    @Override
    public String getMessage() {
        return "Negatives not allowed";
    }
}
