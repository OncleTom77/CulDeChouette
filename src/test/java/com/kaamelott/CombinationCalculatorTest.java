package com.kaamelott;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationCalculatorTest {

    @ParameterizedTest(name = "Chouette de {index} ({0}) : {1}")
    @CsvSource(value = {
            "113, 1",
            "433, 9",
            "446, 16",
            "515, 25",
            "566, 36",
    })
    void should_compute_chouette_combination_as_the_power_of_2_of_the_number_on_the_identical_dices(String roll, int expectedScore) {
        int score = new CombinationCalculator().computeScore(roll);

        assertThat(score).isEqualTo(expectedScore);
    }


    @ParameterizedTest(name = "Velute ({0}) : {1}")
    @CsvSource(value = {
            "123, 18",
            "413, 32",
            "154, 50",
            "235, 50",
            "156, 72",
            "246, 72",
    })
    void should_compute_velute_combination_as_the_double_of_the_power_of_2_of_max_number(String roll, int expectedScore) {
        int score = new CombinationCalculator().computeScore(roll);

        assertThat(score).isEqualTo(expectedScore);
    }
}
