package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VeluteCombinationTest {

    private Dice dice;

    @BeforeEach
    void setUp() {
        this.dice = mock(Dice.class);
    }

    @ParameterizedTest(name = "Velute de {0} : {1}")
    @CsvSource(value = {
            "2, 8",
            "3, 18",
            "4, 32",
            "5, 50",
            "6, 72",
    })
    void should_compute_velute_combination_as_the_double_of_the_power_of_2_of_max_number(int value, int expectedScore) {
        when(dice.third()).thenReturn(value);

        int score = new VeluteCombination().compute(dice);

        assertThat(score).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "Velute {0}")
    @CsvSource(value = {
            "1, 2, 3",
            "1, 3, 4",
            "1, 4, 5",
            "2, 3, 5",
            "1, 5, 6",
            "2, 4, 6",
    })
    void should_have_velute_combination_when_roll_represents_a_velute(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new VeluteCombination().match(dice);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de Velute ({0})")
    @CsvSource(value = {
            "1, 1, 1",
            "2, 4, 5",
            "2, 6, 6",
            "2, 3, 4",
    })
    void should_not_have_velute_combination_when_roll_does_not_represent_a_velute(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new VeluteCombination().match(dice);

        assertThat(match).isFalse();
    }
}