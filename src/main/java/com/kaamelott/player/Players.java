package com.kaamelott.player;

import com.kaamelott.dice.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {

    private static final int CURRENT_PLAYER = 0;

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(List<Player> players) {
        return new Players(players);
    }

    public Dice roll() {
        return currentPlayer().roll();
    }

    public Players updateScore(int score) {
        Player updatedCurrentPlayer = currentPlayer().updateScore(score);
        List<Player> updatedPlayers = nextPlayers(updatedCurrentPlayer);

        return of(updatedPlayers);
    }

    private Player currentPlayer() {
        return players.get(CURRENT_PLAYER);
    }

    private List<Player> nextPlayers(Player updatedCurrentPlayer) {
        List<Player> updatedPlayers = new ArrayList<>(players);
        updatedPlayers.remove(CURRENT_PLAYER);
        updatedPlayers.add(updatedCurrentPlayer);

        return updatedPlayers;
    }

    public boolean hasSomeoneReached(int maxScore) {
        return players.stream()
                .anyMatch(player -> player.hasReached(maxScore));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Player : ")
                .append(currentPlayer().toString())
                .append("\n");
        stringBuilder.append("-------------------------------------\n");
        stringBuilder.append("Name                            Score\n");
        stringBuilder.append("-------------------------------------\n");

        players.stream()
                .sorted()
                .map(Player::toString)
                .forEach(s -> stringBuilder.append(s).append("\n"));

        return stringBuilder.toString();
    }
}
