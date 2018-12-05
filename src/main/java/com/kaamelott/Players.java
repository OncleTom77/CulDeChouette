package com.kaamelott;

import com.kaamelott.dice.Dice;

import java.util.List;

class Players {

    private static final int CURRENT_PLAYER = 0;

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    static Players of(List<Player> players) {
        return new Players(players);
    }

    public Dice roll() {
        return players.get(CURRENT_PLAYER).roll();
    }

    Players updateScore(int score) {
        throw new UnsupportedOperationException();
    }
}
