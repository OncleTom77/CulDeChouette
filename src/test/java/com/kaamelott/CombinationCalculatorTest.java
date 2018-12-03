package com.kaamelott;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationCalculatorTest {

    @ParameterizedTest(name = "Chouette de {index} ({0}) : {1}")
    @CsvSource(value = {
            "113, 1",
            "242, 4",
            "433, 9",
            "446, 16",
            "515, 25",
            "566, 36",
    })
    void should_compute_chouette_combination(String roll, int expectedResult) {
        int score = new CombinationCalculator().computeScore(roll);

        assertThat(score).isEqualTo(expectedResult);
    }
}
