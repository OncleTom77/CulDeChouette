package com.kaamelott.dice;

import java.util.Scanner;

public class ScannerDiceRoller implements DiceRoller {

    private final Scanner scanner;

    private ScannerDiceRoller(Scanner scanner) {
        this.scanner = scanner;
    }

    public static ScannerDiceRoller from(Scanner scanner) {
        return new ScannerDiceRoller(scanner);
    }

    @Override
    public Dice roll() {
        return Dice.from(scanner.nextLine());
    }
}
