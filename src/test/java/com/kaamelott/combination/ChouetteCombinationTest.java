package com.kaamelott.combination;

import com.kaamelott.Dices;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ChouetteCombinationTest {

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
        int score = new ChouetteCombination().compute(value);

        assertThat(score).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "Chouette de {index} : {0}")
    @CsvSource(value = {
            "113",
            "225",
            "334",
            "446",
            "155",
            "566",
    })
    void should_have_chouette_combination_when_roll_represents_a_chouette(String roll) {
        boolean match = new ChouetteCombination().match(Dices.from(roll));

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de Chouette ({0})")
    @CsvSource(value = {
            "111",
            "123",
            "536",
    })
    void should_not_have_chouette_combination_when_roll_does_not_represent_a_chouette(String roll) {
        boolean match = new ChouetteCombination().match(Dices.from(roll));

        assertThat(match).isFalse();
    }
}
