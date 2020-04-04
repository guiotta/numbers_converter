package br.com.otta.numbersconverter.strategy.manager;

import java.util.Collection;

import org.springframework.stereotype.Component;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.strategy.converter.ConverterStrategy;

/**
 * Componente para controlar a execução das implementações de {@link ConverterStrategy}.
 *
 * @author Guilherme
 *
 */
@Component
public class ConverterManager {
    private static final String ITEM_TYPE_EMPTY = "Não foi possível encontrar uma forma de converter o valor passado para este tipo: %s.";

    private final Collection<ConverterStrategy> strategies;

    public ConverterManager(Collection<ConverterStrategy> strategies) {
        this.strategies = strategies;
    }

    public String execute(String userInput, ItemType itemType) {
        ConverterStrategy converterStrategy = strategies.stream()
                .filter(strategy -> strategy.getItemType() == itemType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ITEM_TYPE_EMPTY, itemType)));

        return converterStrategy.convert(userInput);
    }
}
