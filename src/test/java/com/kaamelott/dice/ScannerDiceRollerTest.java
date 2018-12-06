package com.kaamelott.dice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ScannerDiceRollerTest {

    @ParameterizedTest(name = "Input {0} : {1}")
    @CsvSource({
            "234",
            "153",
            "621",
            "634",
    })
    void should_roll_from_command_line(String roll) {
        Scanner scanner = new Scanner(roll);

        ScannerDiceRoller diceRoller = ScannerDiceRoller.from(scanner);

        Dice dice = diceRoller.roll();

        Dice expectedDice = Dice.from(roll);
        assertThat(dice).isEqualTo(expectedDice);
    }
}