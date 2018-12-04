package com.kaamelott.combination;

import com.kaamelott.Dices;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NeantCombinationTest {

    @ParameterizedTest(name = "Néant ({0})")
    @CsvSource(value = {
            "135",
            "126",
            "356",
    })
    void should_return_0_when_compute_neant_combination_calculation(String roll) {
        int score = new NeantCombination().compute(Dices.from(roll));

        assertThat(score).isEqualTo(0);
    }

    @ParameterizedTest(name = "Néant ({0})")
    @CsvSource(value = {
            "135",
            "126",
            "356",
    })
    void should_have_neant_combination_for_every_roll(String roll) {
        boolean match = new NeantCombination().match(Dices.from(roll));

        assertThat(match).isTrue();
    }
}