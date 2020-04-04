package br.com.otta.numbersconverter.factory;

import org.springframework.stereotype.Component;

import br.com.otta.numbersconverter.model.api.ConverterResponse;

/**
 * Componente para construir um {@link ConverterResponse} usando o valor original e o convertido.
 *
 * @author Guilherme
 *
 */
@Component
public class ConverterResponseFactory {

    public ConverterResponse create(String userInput, String convertedValue) {
        return new ConverterResponse(userInput, convertedValue);
    }
}
