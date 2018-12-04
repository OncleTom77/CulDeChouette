package com.kaamelott.combination;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    void should_compute_chouette_combination_as_the_power_of_2_of_the_value_on_the_identical_dices(int value, int expectedScore) {
        int score = ChouetteCombination.from(value).compute();

        assertThat(score).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "Chouette de ({0}) : {1}")
    @CsvSource(value = {
            "1, 113",
            "2, 225",
            "3, 334",
            "4, 446",
            "5, 155",
            "6, 566",
    })
    void should_have_chouette_combination_when_roll_represents_a_chouette(int value, String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        Optional<ChouetteCombination> chouetteCombination = ChouetteCombination.from(orderedDices);

        assertThat(chouetteCombination.isPresent()).isTrue();
        assertThat(chouetteCombination.get()).isEqualTo(ChouetteCombination.from(value));
    }

    @ParameterizedTest(name = "Pas de Chouette ({0}) : {1}")
    @CsvSource(value = {
            "111",
            "123",
            "536",
    })
    void should_not_have_chouette_combination_when_roll_does_not_represent_a_chouette(String roll) {
        List<Integer> orderedDices = roll.chars()
                .boxed()
                .collect(Collectors.toList());

        Optional<ChouetteCombination> chouetteCombination = ChouetteCombination.from(orderedDices);

        assertThat(chouetteCombination.isPresent()).isFalse();
    }
}
