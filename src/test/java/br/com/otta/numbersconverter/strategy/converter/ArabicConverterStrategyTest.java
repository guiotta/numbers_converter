package br.com.otta.numbersconverter.strategy.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.validation.ArabicConverterValidator;

/**
 * Testes do componente {@link ArabicConverterStrategy}.
 *
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class ArabicConverterStrategyTest {
    private static final String INVALID_INPUT = "invalid";

    @Mock
    private ArabicConverterValidator validator;
    @InjectMocks
    private ArabicConverterStrategy strategy;

    @ParameterizedTest
    @MethodSource("provideValues")
    public void shouldCorrectlyConvertValue(String input, String expected) {
        // given
        given(validator.validate(input)).willReturn(Boolean.TRUE);
        // when
        String actualValue = strategy.convert(input);
        // then
        assertEquals(expected, actualValue);
    }

    @Test
    public void shouldCorrectlyThrowsIllegalArgumentsException() {
        // given
        given(validator.validate(INVALID_INPUT)).willReturn(Boolean.FALSE);
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            strategy.convert(INVALID_INPUT);
        });
        // then
    }

    @Test
    public void shouldReturnItemTypeArabic() {
        // given
        // when
        ItemType actualValue = strategy.getItemType();
        // then
        assertEquals(ItemType.ARABIC, actualValue);
    }

    private static Stream<Arguments> provideValues() {
        return Stream.of(
                Arguments.of("X", "10"),
                Arguments.of("XI", "11"),
                Arguments.of("XxiX", "29"),
                Arguments.of("CCCLV", "355")
        );
    }
}
