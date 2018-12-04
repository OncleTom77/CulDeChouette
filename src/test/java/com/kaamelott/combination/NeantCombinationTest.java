package com.kaamelott.combination;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NeantCombinationTest {

    @ParameterizedTest(name = "Néant ({0})")
    @CsvSource(value = {
            "135",
            "126",
            "356",
    })
    void should_return_0_when_compute_neant_combination_calculation(String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        int score = new NeantCombination().compute(orderedDices);

        assertThat(score).isEqualTo(0);
    }

    @ParameterizedTest(name = "Néant ({0})")
    @CsvSource(value = {
            "135",
            "126",
            "356",
    })
    void should_have_neant_combination_for_every_roll(String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        boolean match = new NeantCombination().match(orderedDices);

        assertThat(match).isTrue();
    }
}