package com.kaamelott;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CulDeChouetteCombinationTest {

    @ParameterizedTest(name = "Cul de Chouette de {0} : {1}")
    @CsvSource(value = {
            "1, 50",
            "2, 60",
            "3, 70",
            "4, 80",
            "5, 90",
            "6, 100",
    })
    void should_compute_cul_de_chouette_combination_as_40_plus_number_on_dices_multiply_by_10(int value, int expectedScore) {
        int score = CulDeChouetteCombination.from(value).compute();

        assertThat(score).isEqualTo(expectedScore);
    }
}