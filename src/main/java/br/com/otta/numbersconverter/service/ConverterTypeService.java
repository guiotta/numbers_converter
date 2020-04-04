package br.com.otta.numbersconverter.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;

import br.com.otta.numbersconverter.model.ItemType;

/**
 * Classe de serviço criada para isolar a lógica necessária para operações com os tipos de Conversão.
 *
 * @author Guilherme
 *
 */
@Service
public class ConverterTypeService {

    public Collection<ItemType> listAllValidTypes() {
        return this.callValidValues();
    }

    @VisibleForTesting
    protected Collection<ItemType> callValidValues() {
        return ItemType.validValues();
    }
}
