package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SuiteVeluteCombinationTest {

    private Dice dice;

    @BeforeEach
    void setUp() {
        this.dice = mock(Dice.class);
    }

    @ParameterizedTest(name = "SuiteVelute ({0}) : {1}")
    @CsvSource(value = {
            "1, 2, 3, 18",
    })
    void should_compute_suite_velute_combination_as_a_velute(int first, int second, int third, int expectedScore) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        int score = new SuiteVeluteCombination().compute(dice);

        assertThat(score).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "SuiteVelute ({0})")
    @CsvSource(value = {
            "1, 2, 3",
    })
    void should_have_suite_velute_combination_when_roll_represents_a_suite_and_a_velute(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new SuiteVeluteCombination().match(dice);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de SuiteVelute ({0})")
    @CsvSource(value = {
            "1, 1, 1",
            "2, 4, 5",
            "2, 6, 6",
            "2, 3, 4",
            "2, 3, 5",
    })
    void should_not_have_velute_combination_when_roll_does_not_represent_a_velute(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new SuiteVeluteCombination().match(dice);

        assertThat(match).isFalse();
    }
}