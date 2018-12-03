package com.kaamelott;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class SuiteCombinationTest {

    @Test
    void should_compute_suite_combination_as_10_points_malus() {
        int score = SuiteCombination.from().compute();

        assertThat(score).isEqualTo(-10);
    }

    @ParameterizedTest(name = "Suite {0}")
    @CsvSource(value = {
            "123",
            "234",
            "345",
            "456",
    })
    void should_get_suite_combination_when_there_is_a_suite(String roll) {
        List<Integer> orderedDices = roll.chars().boxed().collect(toList());
        boolean isPresent = SuiteCombination.from(orderedDices).isPresent();

        assertThat(isPresent).isTrue();
    }
}