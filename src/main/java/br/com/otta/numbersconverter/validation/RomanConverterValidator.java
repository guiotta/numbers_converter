package br.com.otta.numbersconverter.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Componente para verificar se todos os characters inseridos pelo usuário representam numerais Arábicos.
 *
 * @author Guilherme
 *
 */
@Component
public class RomanConverterValidator {

    /**
     * Verifica se o valor inserido pelo usuário é válido.
     *
     * @return Retorna {@link Boolean#TRUE} caso seja válido, {@link Boolean#FALSE} caso contrário.
     */
    public boolean validate(String userInput) {
        return StringUtils.isNumeric(userInput);
    }
}
