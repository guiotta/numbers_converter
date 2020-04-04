package br.com.otta.numbersconverter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.model.api.ConverterRequest;
import br.com.otta.numbersconverter.model.api.ConverterResponse;
import br.com.otta.numbersconverter.service.ConverterService;

/**
 * Testes unitários do componente {@link ConverterController}.
 *
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class ConverterControllerTest {
    private static final String INPUT = "input";
    private static final ItemType TYPE = ItemType.ARABIC;

    @Mock
    private ConverterService service;
    @InjectMocks
    private ConverterController controller;

    @Mock
    private ConverterRequest request;
    @Mock
    private ConverterResponse response;

    @BeforeEach
    protected void setUp() {
        given(request.getUserInput()).willReturn(INPUT);
        given(request.getTypeToConvert()).willReturn(TYPE);
        given(service.executeConverter(INPUT, TYPE)).willReturn(response);
    }

    @Test
    public void shouldCorrectlyExecuteConversionOnService() throws Exception {
        // given
        // when
        ResponseEntity<ConverterResponse> actualValue = controller.convert(request);
        // then
        assertEquals(response, actualValue.getBody());
    }

}
