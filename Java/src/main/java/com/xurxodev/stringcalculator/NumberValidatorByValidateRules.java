package com.xurxodev.stringcalculator;

import com.xurxodev.stringcalculator.exception.ValidatorException;

import java.util.List;

public class NumberValidatorByValidateRules implements StringCalculator.NumberValidator{

    List<ValidateRule> validateRules;

    public NumberValidatorByValidateRules(List<ValidateRule> validateRules){
        this.validateRules = validateRules;
    }

    @Override
    public void validate(List<Integer> numbers) throws ValidatorException {
        for (Integer number:numbers) {
            validate(number);
        }
    }

    private boolean validate(Integer number) throws ValidatorException {
        for (ValidateRule validateRule : validateRules) {
            validateRule.validate(number);
        }

        return false;
    }

    public interface ValidateRule {
        void validate(Integer number) throws ValidatorException;
    }
}
