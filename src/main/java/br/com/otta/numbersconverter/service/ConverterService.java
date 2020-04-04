package br.com.otta.numbersconverter.service;

import org.springframework.stereotype.Service;

import br.com.otta.numbersconverter.factory.ConverterResponseFactory;
import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.model.api.ConverterResponse;
import br.com.otta.numbersconverter.strategy.manager.ConverterManager;

/**
 * Classe de serviço para abstrair os comportamentos necessários para a conversão de um valor.
 *
 * @author Guilherme
 *
 */
@Service
public class ConverterService {
    private final ConverterManager converterManager;
    private final ConverterResponseFactory converterResponseFactory;

    public ConverterService(ConverterManager converterManager, ConverterResponseFactory converterResponseFactory) {
        this.converterManager = converterManager;
        this.converterResponseFactory = converterResponseFactory;
    }

    public ConverterResponse executeConverter(String userInput, ItemType itemType) {
        String convertedValue = converterManager.execute(userInput, itemType);

        return converterResponseFactory.create(userInput, convertedValue);
    }
}
