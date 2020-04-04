package br.com.otta.numbersconverter.strategy.converter;

import br.com.otta.numbersconverter.model.ItemType;

public interface ConverterStrategy {
    ItemType getItemType();
    String convert(String userInput);
}
