package com.kaamelott.combination;

import com.kaamelott.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NeantCombinationTest {

    private Dice dice;

    @BeforeEach
    void setUp() {
        this.dice = mock(Dice.class);
    }

    @ParameterizedTest(name = "Néant ({0})")
    @CsvSource(value = {
            "1, 3, 5",
            "1, 2, 6",
            "3, 5, 6",
    })
    void should_return_0_when_compute_neant_combination_calculation(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        int score = new NeantCombination().compute(dice);

        assertThat(score).isEqualTo(0);
    }

    @ParameterizedTest(name = "Néant ({0})")
    @CsvSource(value = {
            "1, 3, 5",
            "1, 2, 6",
            "3, 5, 6",
    })
    void should_have_neant_combination_for_every_roll(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new NeantCombination().match(dice);

        assertThat(match).isTrue();
    }
}