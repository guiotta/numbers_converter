package br.com.otta.numbersconverter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.service.ConverterTypeService;

/**
 * Testes unitários do componente {@link ConverterTypeController}.
 *
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class ConverterTypeControllerTest {
    @Mock
    private ConverterTypeService service;
    @InjectMocks
    private ConverterTypeController controller;

    @Mock
    private Collection<ItemType> itens;

    @BeforeEach
    protected void setUp() {
        given(service.listAllValidTypes()).willReturn(itens);
    }

    @Test
    public void shouldCorrectlyListValidItemTypes() {
        // given
        // when
        ResponseEntity<Collection<ItemType>> actualValue = controller.listAllValidConverterTypes();
        // then
        assertEquals(itens, actualValue.getBody());
    }

}
