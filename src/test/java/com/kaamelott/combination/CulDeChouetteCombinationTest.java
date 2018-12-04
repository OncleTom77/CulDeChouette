package com.kaamelott.combination;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

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
        int score = new CulDeChouetteCombination().compute(value);

        assertThat(score).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "Cul de Chouette de {index} : {0}")
    @CsvSource(value = {
            "111",
            "222",
            "333",
            "444",
            "555",
            "666",
    })
    void should_have_cul_de_chouette_combination_when_roll_represents_a_cul_de_chouette(String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        boolean match = new CulDeChouetteCombination().match(orderedDices);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de Cul de Chouette ({0})")
    @CsvSource(value = {
            "112",
            "145",
            "456",
            "135",
    })
    void should_not_have_cul_de_chouette_combination_when_roll_does_not_represent_a_cul_de_chouette(String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        boolean match = new CulDeChouetteCombination().match(orderedDices);

        assertThat(match).isFalse();
    }
}