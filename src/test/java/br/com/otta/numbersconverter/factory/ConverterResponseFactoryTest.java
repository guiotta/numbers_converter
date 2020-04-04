package br.com.otta.numbersconverter.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.otta.numbersconverter.model.api.ConverterResponse;

/**
 * Testes do componente {@link ConverterResponseFactory}.
 * 
 * @author Guilherme
 *
 */
public class ConverterResponseFactoryTest {
    private static final String ORIGINAL_VALUE = "original";
    private static final String CONVERTED_VALUE = "converted";

    private ConverterResponseFactory factory;

    @BeforeEach
    protected void setUp() {
        this.factory = new ConverterResponseFactory();
    }

    @Test
    public void shouldCorrectlyCreateConverterResponse() throws Exception {
        // given
        // when
        ConverterResponse actualValue = factory.create(ORIGINAL_VALUE, CONVERTED_VALUE);
        // then
        assertEquals(ORIGINAL_VALUE, actualValue.getOriginalValue());
        assertEquals(CONVERTED_VALUE, actualValue.getConvertedValue());
    }

}
