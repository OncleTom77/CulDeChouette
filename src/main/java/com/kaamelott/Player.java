package com.kaamelott;

import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;

class Player {

    private final String name;
    private final int score;
    private final DiceRoller diceRoller;

    private Player(String name, int score, DiceRoller diceRoller) {
        this.name = name;
        this.score = score;
        this.diceRoller = diceRoller;
    }

    static Player of(DiceRoller diceRoller) {
        return of("", diceRoller);
    }

    static Player of(String name, DiceRoller diceRoller) {
        return of(name, 0, diceRoller);
    }

    static Player of(String name, int score, DiceRoller diceRoller) {
        return new Player(name, score, diceRoller);
    }

    Dice roll() {
        return diceRoller.roll();
    }

    Player updateScore(int score) {
        throw new UnsupportedOperationException();
    }
}
