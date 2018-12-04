package com.kaamelott.combination;

import com.kaamelott.Dices;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SuiteVeluteCombinationTest {

    @ParameterizedTest(name = "SuiteVelute ({0}) : {1}")
    @CsvSource(value = {
            "123, 18",
    })
    void should_compute_suite_velute_combination_as_a_velute(String roll, int expectedScore) {
        int score = new SuiteVeluteCombination().compute(Dices.from(roll));

        assertThat(score).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "SuiteVelute ({0})")
    @CsvSource(value = {
            "123",
    })
    void should_have_suite_velute_combination_when_roll_represents_a_suite_and_a_velute(String roll) {
        boolean match = new SuiteVeluteCombination().match(Dices.from(roll));

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de SuiteVelute ({0})")
    @CsvSource(value = {
            "111",
            "245",
            "266",
            "234",
            "235",
    })
    void should_not_have_velute_combination_when_roll_does_not_represent_a_velute(String roll) {
        boolean match = new SuiteVeluteCombination().match(Dices.from(roll));

        assertThat(match).isFalse();
    }
}