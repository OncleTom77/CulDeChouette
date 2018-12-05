package com.kaamelott;

import com.kaamelott.combination.Combinations;

import java.util.List;

class Game {

    private final List<Player> players;
    private final Combinations combinations;

    private Game(List<Player> players, Combinations combinations) {
        this.players = players;
        this.combinations = combinations;
    }

    static Game of(List<Player> players) {
        return new Game(players, Combinations.useDefaults());
    }

    Game nextTurn() {
        throw new UnsupportedOperationException();
    }
}
