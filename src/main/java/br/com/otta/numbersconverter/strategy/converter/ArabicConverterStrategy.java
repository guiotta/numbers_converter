package br.com.otta.numbersconverter.strategy.converter;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.model.Numbers;

/**
 * Componente para realizar a conversão de um valor digitado pelo usuário para um numeral Arábico.
 * 
 * @author Guilherme
 *
 */
@Component
public class ArabicConverterStrategy implements ConverterStrategy {

    @Override
    public ItemType getItemType() {
        return ItemType.ARABIC;
    }

    @Override
    public String convert(String userInput) {
        List<Numbers> reversedNumbers = Numbers.reverse();
        String roman = userInput.toUpperCase(Locale.US);
        int result = 0;
        int index = 0;

        while ((reversedNumbers.size() > index) && (!StringUtils.isBlank(roman))) {
            Numbers selectedNumber = reversedNumbers.get(index);

            if (roman.startsWith(selectedNumber.getRomanValue())) {
                result += selectedNumber.getArabicValue();
                roman = roman.substring(selectedNumber.getRomanValue().length());
            } else {
                index++;
            }
        }

        return String.valueOf(result);
    }

}
