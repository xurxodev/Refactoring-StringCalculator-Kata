package com.xurxodev.stringcalculator.rule;

import com.xurxodev.stringcalculator.NumberValidatorByValidateRules;
import com.xurxodev.stringcalculator.exception.NegativeNumbersNotAllowedException;
import com.xurxodev.stringcalculator.exception.ValidatorException;

public class NegativeNumberValidateRule implements NumberValidatorByValidateRules.ValidateRule {

    @Override
    public void validate(Integer number) throws ValidatorException {
        if (number < 0)
            throw new NegativeNumbersNotAllowedException();
    }
}
