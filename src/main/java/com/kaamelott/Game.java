package com.kaamelott;

import com.kaamelott.combination.Combination;
import com.kaamelott.combination.Combinations;
import com.kaamelott.dice.Dice;

import java.util.Objects;

class Game {

    private final Players players;
    private final Combinations combinations;

    private Game(Players players, Combinations combinations) {
        this.players = players;
        this.combinations = combinations;
    }

    static Game of(Players players) {
        return of(players, Combinations.useDefaults());
    }

    static Game of(Players players, Combinations combinations) {
        return new Game(players, combinations);
    }

    Game nextTurn() {
        Dice dice = players.roll();
        Combination matchedCombination = combinations.match(dice);
        int score = matchedCombination.compute(dice);
        Players updatedPlayers = this.players.updateScore(score);

        return of(updatedPlayers, combinations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(players, game.players) &&
                Objects.equals(combinations, game.combinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, combinations);
    }
}
