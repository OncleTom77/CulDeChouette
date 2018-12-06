package com.kaamelott.player;

import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;

import java.util.Objects;

public class Player implements Comparable<Player> {

    private final String name;
    private final int score;
    private final DiceRoller diceRoller;

    private Player(String name, int score, DiceRoller diceRoller) {
        this.name = name;
        this.score = score;
        this.diceRoller = diceRoller;
    }

    public static Player of(String name, DiceRoller diceRoller) {
        return of(name, 0, diceRoller);
    }

    public static Player of(String name, int score, DiceRoller diceRoller) {
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
        return this.score >= score;
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

    @Override
    public String toString() {
        return name + getSpaces() + score;
    }

    private String getSpaces() {
        int length = 32 - name.length();
        StringBuilder spaces = new StringBuilder();

        for (int i = 0; i < length; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }

    @Override
    public int compareTo(Player o) {
        return this.name.compareTo(o.name);
    }
}
