package com.kaamelott.combination;

import com.kaamelott.combination.ChouetteCombination;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ChouetteCalculationTest {

    @ParameterizedTest(name = "Chouette de {0} : {1}")
    @CsvSource(value = {
            "1, 1",
            "2, 4",
            "3, 9",
            "4, 16",
            "5, 25",
            "6, 36",
    })
    void should_compute_chouette_combination_as_the_power_of_2_of_the_number_on_the_identical_dices(int value, int expectedScore) {
        int score = ChouetteCombination.from(value).compute();

        assertThat(score).isEqualTo(expectedScore);
    }
}
