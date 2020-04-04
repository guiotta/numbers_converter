package br.com.otta.numbersconverter.strategy.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.model.Numbers;
import br.com.otta.numbersconverter.validation.RomanConverterValidator;

/**
 * Componente para realizar a conversão de um valor digitado pelo usuário para um numeral Romano.
 * 
 * @author Guilherme
 *
 */
@Component
public class RomanConverterStrategy implements ConverterStrategy {
    private static final String VALIDATION_ERROR = "Valor inserido pelo usuário não é um numeral arábico válido: %s.";

    private final RomanConverterValidator validator;

    public RomanConverterStrategy(RomanConverterValidator validator) {
        this.validator = validator;
    }

    @Override
    public ItemType getItemType() {
        return ItemType.ROMAN;
    }

    @Override
    public String convert(String userInput) {
        if (!validator.validate(userInput)) {
            throw new IllegalArgumentException(String.format(VALIDATION_ERROR, userInput));
        }

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
