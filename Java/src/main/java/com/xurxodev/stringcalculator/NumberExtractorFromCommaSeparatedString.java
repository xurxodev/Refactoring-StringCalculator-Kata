package com.xurxodev.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractorFromCommaSeparatedString implements StringCalculator.NumberExtractor {

    @Override
    public List<Integer> extract(String numbers) {
        List<Integer> numberList = new ArrayList<>();

        if (numbers != ""){
            for (String number:numbers.split(",")) {
                numberList.add(Integer.parseInt(number));
            }
        }

        return numberList;
    }
}
