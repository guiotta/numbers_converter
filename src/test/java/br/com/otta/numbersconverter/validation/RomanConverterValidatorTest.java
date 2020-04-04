package br.com.otta.numbersconverter.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Testes do componente {@link RomanConverterValidator}.
 * @author Guilherme
 *
 */
public class RomanConverterValidatorTest {
    private RomanConverterValidator validator;

    @BeforeEach
    protected void setUp() {
        this.validator = new RomanConverterValidator();
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
                Arguments.of("1", true),
                Arguments.of("001", true),
                Arguments.of("987654", true),
                Arguments.of(null, false),
                Arguments.of("null", false),
                Arguments.of("  ", false),
                Arguments.of("X", false),
                Arguments.of("C", false),
                Arguments.of("not blank", false)
        );
    }
}
