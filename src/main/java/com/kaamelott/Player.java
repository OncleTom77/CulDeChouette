package com.kaamelott;

import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;

class Player {

    private final DiceRoller diceRoller;

    private Player(DiceRoller diceRoller) {
        this.diceRoller = diceRoller;
    }

    static Player of(DiceRoller diceRoller) {
        return new Player(diceRoller);
    }

    Dice roll() {
        return diceRoller.roll();
    }
}
