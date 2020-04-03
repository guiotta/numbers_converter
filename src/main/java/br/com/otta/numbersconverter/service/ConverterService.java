package br.com.otta.numbersconverter.service;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import br.com.otta.numbersconverter.model.Numbers;

@Service
public class ConverterService {

    public String convertToRoman(Integer arabic) {
        StringBuilder resultBuilder = new StringBuilder();
        List<Numbers> reversedNumbers = Numbers.reverse();
        int index = 0;

        while((reversedNumbers.size() > index) && (arabic > 0)) {
            Numbers selectedNumber = reversedNumbers.get(index);

            if (selectedNumber.getArabicValue() <= arabic) {
                resultBuilder.append(selectedNumber.getRomanValue());
                arabic -= selectedNumber.getArabicValue();
            } else {
                index++;
            }
        }

        return resultBuilder.toString();
    }

    public int convertToArabic(String input) {
        List<Numbers> reversedNumbers = Numbers.reverse();
        String roman = input.toUpperCase(Locale.US);
        int result = 0;
        int index = 0;

        while((reversedNumbers.size() > index) && (!StringUtils.isBlank(roman))) {
            Numbers selectedNumber = reversedNumbers.get(index);

            if (roman.startsWith(selectedNumber.getRomanValue())) {
                result += selectedNumber.getArabicValue();
                roman = roman.substring(selectedNumber.getRomanValue().length());
            } else {
                index++;
            }
        }

        return result;
    }
}
