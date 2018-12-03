package com.kaamelott;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ChouetteVeluteCombinationTest {

    @ParameterizedTest(name = "Chouette-Velute de {0} : {1}")
    @CsvSource(value = {
            "2, 8",
            "4, 32",
            "6, 72",
    })
    void should_compute_chouette_velute_combination_as_velute(int value, int expectedScore) {
        int score = ChouetteVeluteCombination.from(VeluteCombination.from(value)).compute();

        assertThat(score).isEqualTo(expectedScore);
    }
}