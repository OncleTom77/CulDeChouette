package com.kaamelott;

import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;

import java.util.Objects;

class Player {

    private final String name;
    private final int score;
    private final DiceRoller diceRoller;

    private Player(String name, int score, DiceRoller diceRoller) {
        this.name = name;
        this.score = score;
        this.diceRoller = diceRoller;
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
        int updatedScore = this.score + score;
        return of(name, updatedScore, diceRoller);
    }

    boolean hasReached(int score) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score &&
                Objects.equals(name, player.name) &&
                Objects.equals(diceRoller, player.diceRoller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, diceRoller);
    }
}
