package com.kaamelott.combination;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @ParameterizedTest(name = "Velute {0} : {1}")
    @CsvSource(value = {
            "3, 123",
            "4, 134",
            "5, 145",
            "5, 235",
            "6, 156",
            "6, 246",
    })
    void should_have_velute_combination_when_roll_represents_a_velute(int value, String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        Optional<VeluteCombination> veluteCombination = VeluteCombination.from(orderedDices);

        assertThat(veluteCombination.isPresent()).isTrue();
        assertThat(veluteCombination.get()).isEqualTo(VeluteCombination.from(value));
    }

    @ParameterizedTest(name = "Pas de Velute ({0}) : {1}")
    @CsvSource(value = {
            "111",
            "245",
            "266",
            "234",
    })
    void should_not_have_velute_combination_when_roll_does_not_represent_a_velute(String roll) {
        List<Integer> orderedDices = roll.chars()
                .boxed()
                .collect(Collectors.toList());

        Optional<VeluteCombination> veluteCombination = VeluteCombination.from(orderedDices);

        assertThat(veluteCombination.isPresent()).isFalse();
    }
}