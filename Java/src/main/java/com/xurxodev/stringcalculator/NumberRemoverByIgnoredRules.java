package com.xurxodev.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class NumberRemoverByIgnoredRules implements StringCalculator.NumberRemover{

    List<IgnoredRule> ignoredRules;

    public NumberRemoverByIgnoredRules(List<IgnoredRule> ignoredRules){
        this.ignoredRules = ignoredRules;
    }

    @Override
    public List<Integer> removeNumbersToIgnore(List<Integer> numbers) {
        List<Integer> numbersWithoutIgnored = new ArrayList<>();

        for (Integer number:numbers) {
            if (!isIgnored(number))
                numbersWithoutIgnored.add(number);
        }

        return numbersWithoutIgnored;
    }

    private boolean isIgnored(Integer number){
        for (IgnoredRule ignoreRule : ignoredRules) {
            if(ignoreRule.isIgnored(number))
                return true;
        }

        return false;
    }

    public interface IgnoredRule {

        boolean isIgnored(Integer number);

    }
}
