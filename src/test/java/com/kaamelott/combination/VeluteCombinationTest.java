package com.kaamelott.combination;

import com.kaamelott.combination.VeluteCombination;
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
        int score = VeluteCombination.from(value).compute();

        assertThat(score).isEqualTo(expectedScore);
    }
}