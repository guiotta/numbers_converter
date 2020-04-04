package br.com.otta.numbersconverter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.otta.numbersconverter.model.ItemType;

/**
 * Testes unitários do componente {@link ConverterTypeService}.
 * 
 * @author Guilherme
 *
 */
@ExtendWith(MockitoExtension.class)
public class ConverterTypeServiceTest {
    private ConverterTypeService service;

    @Mock
    private Collection<ItemType> validTypes;

    @BeforeEach
    protected void setUp() {
        this.service = spy(new ConverterTypeService());

        when(service.callValidValues()).thenReturn(validTypes);
    }

    @Test
    public void shouldListValidItemTypes() throws Exception {
        // given
        // when
        Collection<ItemType> actualValue = service.listAllValidTypes();
        // then
        assertEquals(validTypes, actualValue);
    }

}
