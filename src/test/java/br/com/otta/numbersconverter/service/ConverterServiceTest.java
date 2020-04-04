package br.com.otta.numbersconverter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otta.numbersconverter.factory.ConverterResponseFactory;
import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.model.api.ConverterResponse;
import br.com.otta.numbersconverter.strategy.manager.ConverterManager;

/**
 * Testes unitários do componente {@link ConverterService}.
 *
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class ConverterServiceTest {
    private static final String INPUT = "input";
    private static final String CONVERTED = "converted";
    private static final ItemType TYPE = ItemType.ARABIC;

    @Mock
    private ConverterManager converterManager;

    @Mock
    private ConverterResponseFactory converterResponseFactory;
    @InjectMocks
    private ConverterService converterService;

    @Mock
    private ConverterResponse response;

    @BeforeEach
    protected void setUp() {
        given(converterManager.execute(INPUT, TYPE)).willReturn(CONVERTED);
        given(converterResponseFactory.create(INPUT, CONVERTED)).willReturn(response);
    }

    @Test
    public void shouldConvertUserInput() {
        // given
        // when
        ConverterResponse actualValue = converterService.executeConverter(INPUT, TYPE);
        // then
        assertEquals(response, actualValue);
    }

}
