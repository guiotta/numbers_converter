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
import br.com.otta.numbersconverter.validation.RomanConverterValidator;

/**
 * Testes do componente {@link RomanConverterStrategy}.
 *
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class RomanConverterStrategyTest {
    private static final String INVALID_INPUT = "invalid";
    
    @Mock
    private RomanConverterValidator validator;
    @InjectMocks
    private RomanConverterStrategy strategy;

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
        assertEquals(ItemType.ROMAN, actualValue);
    }

    private static Stream<Arguments> provideValues() {
        return Stream.of(
                Arguments.of("10", "X"),
                Arguments.of("11", "XI"),
                Arguments.of("29", "XXIX"),
                Arguments.of("355", "CCCLV"),
                Arguments.of("1250", "MCCL")
        );
    }
}
