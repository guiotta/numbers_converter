package br.com.otta.numbersconverter.strategy.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.strategy.converter.ArabicConverterStrategy;
import br.com.otta.numbersconverter.strategy.converter.RomanConverterStrategy;

/**
 * Testes do componente {@link ConverterManager}.
 *
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class ConverterManagerTest {
    private static final String INPUT = "input";
    private static final String RESULT = "result";

    @Mock
    private ArabicConverterStrategy arabicStrategy;
    @Mock
    private RomanConverterStrategy romanStrategy;
    private ConverterManager converterManager;

    @BeforeEach
    protected void setUp() {
        this.converterManager = new ConverterManager(Lists.list(arabicStrategy, romanStrategy));

        given(arabicStrategy.getItemType()).willReturn(ItemType.ARABIC);
        given(romanStrategy.getItemType()).willReturn(ItemType.ROMAN);
    }

    @Test
    public void shouldCorrectlyExecuteConversion() {
        // given
        given(romanStrategy.convert(INPUT)).willReturn(RESULT);
        // when
        String actualValue = converterManager.execute(INPUT, ItemType.ROMAN);
        // then
        assertEquals(RESULT, actualValue);
    }

    @Test
    public void shouldThrowIllegalArgumentsExceptionWhenCollectionFilteredIdEmpty() {
        // given
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            converterManager.execute(INPUT, ItemType.UNKNOWN);
        });
        // then
    }

}
