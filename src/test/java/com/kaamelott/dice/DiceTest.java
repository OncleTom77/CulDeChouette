package com.kaamelott.dice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DiceTest {

    @ParameterizedTest(name = "Dice from {0} : {1}")
    @CsvSource(value = {
            "123, 1, 2, 3",
            "216, 1, 2, 6",
            "531, 1, 3, 5",
            "444, 4, 4, 4",
            "535, 3, 5, 5",
            "264, 2, 4, 6",
    })
    void should_ordered_dice_correctly(String roll, int first, int second, int third) {

        Dice dice = Dice.from(roll);

        assertThat(dice.first()).isEqualTo(first);
        assertThat(dice.second()).isEqualTo(second);
        assertThat(dice.third()).isEqualTo(third);
    }
}