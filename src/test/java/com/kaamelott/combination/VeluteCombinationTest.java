package com.kaamelott.combination;

import com.kaamelott.Dice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class VeluteCombinationTest {

    @ParameterizedTest(name = "Velute de {0} : {1}")
    @CsvSource(value = {
            "2, 8",
            "3, 18",
            "4, 32",
            "5, 50",
            "6, 72",
    })
    void should_compute_velute_combination_as_the_double_of_the_power_of_2_of_max_number(int value, int expectedScore) {
        int score = new VeluteCombination().compute(value);

        assertThat(score).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "Velute {0}")
    @CsvSource(value = {
            "123",
            "134",
            "145",
            "235",
            "156",
            "246",
    })
    void should_have_velute_combination_when_roll_represents_a_velute(String roll) {
        boolean match = new VeluteCombination().match(Dice.from(roll));

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de Velute ({0})")
    @CsvSource(value = {
            "111",
            "245",
            "266",
            "234",
    })
    void should_not_have_velute_combination_when_roll_does_not_represent_a_velute(String roll) {
        boolean match = new VeluteCombination().match(Dice.from(roll));

        assertThat(match).isFalse();
    }
}