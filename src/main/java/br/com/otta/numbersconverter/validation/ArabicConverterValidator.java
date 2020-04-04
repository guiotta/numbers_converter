package br.com.otta.numbersconverter.validation;

import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * Componente para verificar se todos os characters inseridos pelo usuário representam numerais Romanos.
 *
 * @author Guilherme
 *
 */
@Component
public class ArabicConverterValidator {
    private static final String NON_ROMAN_NUMERALS_REGEX = "[^IVXLCDM]";
    private static final Pattern NON_ROMAN_NUMERALS_PATTERN = Pattern.compile(NON_ROMAN_NUMERALS_REGEX);

    /**
     * Verifica se o valor inserido pelo usuário é válido.
     *
     * @return Retorna {@link Boolean#TRUE} caso seja válido, {@link Boolean#FALSE} caso contrário.
     */
    public boolean validate(String userInput) {
        return !NON_ROMAN_NUMERALS_PATTERN.matcher(userInput.toUpperCase(Locale.US)).find();
    }
}
