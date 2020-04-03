package br.com.otta.numbersconverter.service;

import org.springframework.stereotype.Service;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.strategy.manager.ConverterManager;

@Service
public class ConverterService {
    private final ConverterManager converterManager;

    public ConverterService(ConverterManager converterManager) {
        this.converterManager = converterManager;
    }

    public String executeConverter(String userInput, int optionSelected) {
        ItemType itemType = ItemType.get(optionSelected);

        return converterManager.execute(userInput, itemType);
    }
}
