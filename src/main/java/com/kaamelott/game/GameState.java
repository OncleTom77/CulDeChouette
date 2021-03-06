package com.kaamelott.game;

import com.kaamelott.combination.Combinations;
import com.kaamelott.dice.Dice;
import com.kaamelott.player.Players;

import java.util.Objects;

public class GameState {

    private static final int MAX_SCORE = 343;

    private final Players players;
    private final Combinations combinations;

    private GameState(Players players, Combinations combinations) {
        this.players = players;
        this.combinations = combinations;
    }

    public static GameState of(Players players) {
        return of(players, Combinations.useDefaults());
    }

    static GameState of(Players players, Combinations combinations) {
        return new GameState(players, combinations);
    }

    GameState nextState() {
        Dice dice = players.roll();
        Players updatedPlayers = combinations
                .match(dice)
                .compute(dice, players);

        Players nextPlayers = updatedPlayers.nextPlayers();
        return of(nextPlayers, combinations);
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
