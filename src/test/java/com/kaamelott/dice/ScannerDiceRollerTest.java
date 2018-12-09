package com.kaamelott.dice;

import com.kaamelott.game.GameOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        GameOutput gameOutput = mock(GameOutput.class);

        ScannerDiceRoller diceRoller = ScannerDiceRoller.from(scanner, gameOutput);

        Dice dice = diceRoller.roll();

        verify(gameOutput).print("Roll : ");

        Dice expectedDice = Dice.from(roll);
        assertThat(dice).isEqualTo(expectedDice);
    }
}