package com.kaamelott;

import com.kaamelott.combination.Combinations;
import com.kaamelott.dice.Dice;

import java.util.Objects;

class GameState {

    private static final int MAX_SCORE = 343;

    private final Players players;
    private final Combinations combinations;

    private GameState(Players players, Combinations combinations) {
        this.players = players;
        this.combinations = combinations;
    }

    static GameState of(Players players) {
        return of(players, Combinations.useDefaults());
    }

    static GameState of(Players players, Combinations combinations) {
        return new GameState(players, combinations);
    }

    GameState nextState() {
        Dice dice = players.roll();
        int score = combinations
                .match(dice)
                .compute(dice);

        Players updatedPlayers = players.updateScore(score);

        return of(updatedPlayers, combinations);
    }

    boolean hasNext() {
        return !players.hasSomeoneReached(MAX_SCORE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameState gameState = (GameState) o;
        return Objects.equals(players, gameState.players) &&
                Objects.equals(combinations, gameState.combinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, combinations);
    }

    @Override
    public String toString() {
        return players.toString();
    }
}
