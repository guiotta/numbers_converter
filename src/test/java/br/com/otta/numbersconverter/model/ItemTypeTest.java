package br.com.otta.numbersconverter.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes unitários da Enum {@link ItemType}.
 * 
 * @author Guilherme
 *
 */
public class ItemTypeTest {

    @BeforeEach
    protected void setUp() throws Exception {
    }

    @Test
    public void shouldReturnValidValues() throws Exception {
        // given
        // when
        Collection<ItemType> actualValue = ItemType.validValues();
        // then
        assertThat(actualValue, containsInAnyOrder(ItemType.ROMAN, ItemType.ARABIC));
    }

}
