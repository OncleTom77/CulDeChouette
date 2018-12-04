package com.kaamelott.combination;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class SuiteCombinationTest {

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "123",
            "234",
            "345",
            "456",
    })
    void should_compute_suite_combination_as_10_points_malus(String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());
        int score = new SuiteCombination().compute(orderedDices);

        assertThat(score).isEqualTo(-10);
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "123",
            "234",
            "345",
            "456",
    })
    void should_have_suite_combination_when_roll_represents_a_suite(String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        boolean match = new SuiteCombination().match(orderedDices);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "116",
            "333",
            "235",
            "136",
    })
    void should_not_have_suite_combination_when_roll_does_not_represent_a_suite(String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .collect(Collectors.toList());

        boolean match = new SuiteCombination().match(orderedDices);

        assertThat(match).isFalse();
    }
}