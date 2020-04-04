package br.com.otta.numbersconverter.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Testes do componente {@link ArabicConverterValidator}.
 * @author Guilherme
 *
 */
public class ArabicConverterValidatorTest {
    private ArabicConverterValidator validator;

    @BeforeEach
    protected void setUp() {
        this.validator = new ArabicConverterValidator();
    }

    @ParameterizedTest
    @MethodSource("provideValues")
    public void shouldSuccessfullyValidate(String input, boolean expect) throws Exception {
        // given
        // when
        boolean actualValue = validator.validate(input);
        // then
        assertEquals(expect, actualValue);
    }

    private static Stream<Arguments> provideValues() {
        return Stream.of(
                Arguments.of("X", true),
                Arguments.of("XI", true),
                Arguments.of(null, false),
                Arguments.of("null", false),
                Arguments.of("  ", false),
                Arguments.of("100", false),
                Arguments.of("not blank", false)
        );
    }

}
