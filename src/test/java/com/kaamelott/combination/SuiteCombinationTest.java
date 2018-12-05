package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SuiteCombinationTest {

    private Dice dice;

    @BeforeEach
    void setUp() {
        dice = mock(Dice.class);
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "1, 2, 3",
            "2, 3, 4",
            "3, 4, 5",
            "4, 5, 6",
    })
    void should_compute_suite_combination_as_10_points_malus(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        int score = new SuiteCombination().compute(dice);

        assertThat(score).isEqualTo(-10);
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "1, 2, 3",
            "2, 3, 4",
            "3, 4, 5",
            "4, 5, 6",
    })
    void should_have_suite_combination_when_roll_represents_a_suite(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new SuiteCombination().match(dice);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "1, 1, 6",
            "3, 3, 3",
            "2, 3, 5",
            "1, 3, 6",
    })
    void should_not_have_suite_combination_when_roll_does_not_represent_a_suite(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new SuiteCombination().match(dice);

        assertThat(match).isFalse();
    }
}