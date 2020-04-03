package br.com.otta.numbersconverter.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Numbers {
    ONE(1, "I"),
    FOUR(4, "IV"),
    FIVE(5, "V"),
    NINE(9, "IX"),
    TEN(10, "X"),
    FORTY(40, "XL"),
    FIFTY(50, "L"),
    NINETY(90, "XC"),
    ONE_HUNDRED(100, "C"),
    FOUR_HUNDRED(400, "CD"),
    FIVE_HUNDRED(500, "D"),
    NINE_HUNDRED(900, "CM"),
    THOUSAND(1000, "M");

    private int arabicValue;
    private String romanValue;

    private Numbers(int arabicValue, String romanValue) {
        this.arabicValue = arabicValue;
        this.romanValue = romanValue;
    }

    public int getArabicValue() {
        return arabicValue;
    }

    public String getRomanValue() {
        return romanValue;
    }

    public static List<Numbers> reverse() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((Numbers e) -> e.arabicValue).reversed())
                .collect(Collectors.toList());
    }
}
