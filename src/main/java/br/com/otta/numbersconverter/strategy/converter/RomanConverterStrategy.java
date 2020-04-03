package br.com.otta.numbersconverter.strategy.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.model.Numbers;

/**
 * Componente para realizar a conversão de um valor digitado pelo usuário para um numeral Romano.
 * 
 * @author Guilherme
 *
 */
@Component
public class RomanConverterStrategy implements ConverterStrategy {

    @Override
    public ItemType getItemType() {
        return ItemType.ROMAN;
    }

    @Override
    public String convert(String userInput) {
        Integer arabic = Integer.valueOf(userInput);

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

}
