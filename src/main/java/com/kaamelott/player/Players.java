package com.kaamelott.player;

import com.kaamelott.dice.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Players {

    private static final int CURRENT_PLAYER = 0;

    private final List<Player> players;
    private final PlayersInput playersInput;

    private Players(List<Player> players, PlayersInput playersInput) {
        this.players = players;
        this.playersInput = playersInput;
    }

    public static Players of(List<Player> players, PlayersInput playersInput) {
        return new Players(players, playersInput);
    }

    public Dice roll() {
        return currentPlayer().roll();
    }

    public Player currentPlayer() {
        return players.get(CURRENT_PLAYER);
    }

    public boolean hasSomeoneReached(int maxScore) {
        return players.stream()
                .anyMatch(player -> player.hasReached(maxScore));
    }

    public Player requestPlayer(String question) {
        Optional<Player> player;

        do {
            final String playerName = playersInput.read(question);
            player = findPlayerByName(playerName);
        } while(!player.isPresent());

        return player.get();
    }

    private Optional<Player> findPlayerByName(String playerName) {
        return players
                .stream()
                .filter(p -> p.isNamed(playerName))
                .findFirst();
    }

    public Players update(Player player, Player updatedPlayer) {
        final int index = players.indexOf(player);
        final List<Player> updatedPlayers = new ArrayList<>(players);
        updatedPlayers.remove(index);
        updatedPlayers.add(index, updatedPlayer);

        return of(updatedPlayers, playersInput);
    }

    public Players nextPlayers() {
        List<Player> nextPlayers = new ArrayList<>(players);
        Player player = currentPlayer();
        nextPlayers.remove(CURRENT_PLAYER);
        nextPlayers.add(player);

        return of(nextPlayers, playersInput);
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
        stringBuilder
                .append("-------------------------------------\n")
                .append("Name                            Score\n")
                .append("-------------------------------------\n");

        players.stream()
                .sorted()
                .map(Player::toString)
                .forEach(s -> stringBuilder.append(s).append("\n"));

        stringBuilder
                .append("-------------------------------------\n")
                .append("Current player : ")
                .append(currentPlayer().getName())
                .append("\n");

        return stringBuilder.toString();
    }
}
