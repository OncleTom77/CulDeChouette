package com.kaamelott;

import com.kaamelott.dice.Dice;

import java.util.List;

class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    static Players of(List<Player> players) {
        return new Players(players);
    }

    public Dice roll() {
        throw new UnsupportedOperationException();
    }

    Players updateScore(int score) {
        throw new UnsupportedOperationException();
    }
}
