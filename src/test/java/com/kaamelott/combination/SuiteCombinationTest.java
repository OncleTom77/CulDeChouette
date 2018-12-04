package com.kaamelott.combination;

import com.kaamelott.Dice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SuiteCombinationTest {

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "123",
            "234",
            "345",
            "456",
    })
    void should_compute_suite_combination_as_10_points_malus(String roll) {
        int score = new SuiteCombination().compute(Dice.from(roll));

        assertThat(score).isEqualTo(-10);
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "123",
            "234",
            "345",
            "456",
    })
    void should_have_suite_combination_when_roll_represents_a_suite(String roll) {
        boolean match = new SuiteCombination().match(Dice.from(roll));

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "116",
            "333",
            "235",
            "136",
    })
    void should_not_have_suite_combination_when_roll_does_not_represent_a_suite(String roll) {
        boolean match = new SuiteCombination().match(Dice.from(roll));

        assertThat(match).isFalse();
    }
}