package com.kaamelott.combination;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;
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
        int score = ChouetteVeluteCombination.from(VeluteCombination.from(value)).compute();

        assertThat(score).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "Chouette-Velute de {0} : {1}")
    @CsvSource(value = {
            "2, 112",
            "4, 224",
            "6, 336",
    })
    void should_have_chouette_velute_combination_when_roll_represents_a_chouette_velute(int value, String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        Optional<ChouetteVeluteCombination> chouetteVeluteCombination = ChouetteVeluteCombination.from(orderedDices);

        assertThat(chouetteVeluteCombination.isPresent()).isTrue();
        assertThat(chouetteVeluteCombination.get()).isEqualTo(ChouetteVeluteCombination.from(VeluteCombination.from(value)));
    }

    @ParameterizedTest(name = "Pas de Chouette-Velute de {0} : {1}")
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

        Optional<ChouetteVeluteCombination> chouetteVeluteCombination = ChouetteVeluteCombination.from(orderedDices);

        assertThat(chouetteVeluteCombination.isPresent()).isFalse();
    }
}