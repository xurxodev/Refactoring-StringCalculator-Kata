package com.xurxodev.stringcalculator.rule;

import com.xurxodev.stringcalculator.NumberRemoverByIgnoredRules;

public class NumberGreaterThanIgnoredRule implements NumberRemoverByIgnoredRules.IgnoredRule {

    private final Integer maxValue;

    public NumberGreaterThanIgnoredRule(Integer maxValue){
        this.maxValue = maxValue;
    }

    @Override
    public boolean isIgnored(Integer number) {
        return number > maxValue;
    }
}
