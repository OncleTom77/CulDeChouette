package com.kaamelott.dice;

import com.kaamelott.game.GameOutput;

import java.util.Scanner;

public class ScannerDiceRoller implements DiceRoller {

    private final Scanner scanner;
    private final GameOutput gameOutput;

    private ScannerDiceRoller(Scanner scanner, GameOutput gameOutput) {
        this.scanner = scanner;
        this.gameOutput = gameOutput;
    }

    public static ScannerDiceRoller from(Scanner scanner, GameOutput gameOutput) {
        return new ScannerDiceRoller(scanner, gameOutput);
    }

    @Override
    public Dice roll() {
        gameOutput.print("Roll : ");
        return Dice.from(scanner.nextLine());
    }
}
