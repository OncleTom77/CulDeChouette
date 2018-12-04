package com.kaamelott.combination;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ChouetteVeluteCombinationTest {

    @ParameterizedTest(name = "Chouette-Velute de {0} : {1}")
    @CsvSource(value = {
            "2, 8",
            "4, 32",
            "6, 72",
    })
    void should_compute_chouette_velute_combination_as_velute(int value, int expectedScore) {
        int score = new ChouetteVeluteCombination().compute(value);

        assertThat(score).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "Chouette-Velute ({0})")
    @CsvSource(value = {
            "112",
            "224",
            "336",
    })
    void should_have_chouette_velute_combination_when_roll_represents_a_chouette_velute(String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        boolean match = new ChouetteVeluteCombination().match(orderedDices);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de Chouette-Velute ({0})")
    @CsvSource(value = {
            "113",
            "222",
            "234",
            "146",
    })
    void should_not_have_chouette_velute_combination_when_roll_does_not_represent_a_chouette_velute(String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        boolean match = new ChouetteVeluteCombination().match(orderedDices);

        assertThat(match).isFalse();
    }
}