package com.kaamelott.player;

import com.kaamelott.dice.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PlayersTest {

    private PlayersInput playersInput;

    @BeforeEach
    void setUp() {
        playersInput = mock(PlayersInput.class);
    }

    @Test
    void should_roll_current_player() {
        Player currentPlayer = mock(Player.class);
        Player nextPlayer = mock(Player.class);
        Dice expectedDice = mock(Dice.class);

        Players players = Players.of(asList(
                currentPlayer,
                nextPlayer
        ), playersInput);

        when(currentPlayer.roll()).thenReturn(expectedDice);

        Dice dice = players.roll();

        verify(currentPlayer).roll();
        verify(nextPlayer, never()).roll();

        assertThat(dice).isEqualTo(expectedDice);
    }

    @Test
    void should_update_the_current_player_score_and_update_players_order() {
        Player firstPlayer = mock(Player.class);
        Player updatedFirstPlayer = mock(Player.class);
        Player secondPlayer = mock(Player.class);

        int score = 0;
        Players players = Players.of(asList(firstPlayer, secondPlayer), playersInput);
        Players expectedPlayers = Players.of(asList(secondPlayer, updatedFirstPlayer), playersInput);

        when(firstPlayer.updateScore(score)).thenReturn(updatedFirstPlayer);

        Players updatedPlayers = players.updateScore(score);

        verify(firstPlayer).updateScore(score);
        assertThat(updatedPlayers).isEqualTo(expectedPlayers);
    }

    @Test
    void should_check_if_a_player_has_reached_a_score() {
        Player firstPlayer = mock(Player.class);
        Player secondPlayer = mock(Player.class);

        int score = 0;
        Players players = Players.of(asList(firstPlayer, secondPlayer), playersInput);

        when(firstPlayer.hasReached(score)).thenReturn(false);
        when(secondPlayer.hasReached(score)).thenReturn(true);

        boolean hasSomeoneReached = players.hasSomeoneReached(score);

        verify(firstPlayer).hasReached(score);
        verify(secondPlayer).hasReached(score);
        assertThat(hasSomeoneReached).isTrue();
    }

    @Test
    void should_request_a_player() {
        Player firstPlayer = mock(Player.class);
        Player secondPlayer = mock(Player.class);
        PlayersInput playersInput = this.playersInput;

        String playerName = "toto";
        when(playersInput.read()).thenReturn(playerName);
        when(firstPlayer.isNamed(playerName)).thenReturn(false);
        when(secondPlayer.isNamed(playerName)).thenReturn(true);

        Players players = Players.of(
                asList(
                        firstPlayer,
                        secondPlayer
                ),
                playersInput
        );

        Player player = players.requestPlayer();

        assertThat(player).isEqualTo(secondPlayer);
    }

    @Test
    void should_request_a_player_while_it_is_unknown() {
        Player firstPlayer = mock(Player.class);
        Player secondPlayer = mock(Player.class);
        PlayersInput playersInput = this.playersInput;

        String playerName = "toto";
        when(playersInput.read()).thenReturn("unknown", "", playerName);
        when(firstPlayer.isNamed(playerName)).thenReturn(false);
        when(secondPlayer.isNamed(playerName)).thenReturn(false, false, true);

        Players players = Players.of(
                asList(
                        firstPlayer,
                        secondPlayer
                ),
                playersInput
        );

        Player player = players.requestPlayer();

        assertThat(player).isEqualTo(secondPlayer);
    }

    @Test
    void should_update_player() {
        Player firstPlayer = mock(Player.class);
        Player secondPlayer = mock(Player.class);
        Player updatedPlayer = mock(Player.class);
        PlayersInput playersInput = this.playersInput;

        Players players = Players.of(
                asList(
                        firstPlayer,
                        secondPlayer
                ),
                playersInput
        );

        Players updatedPlayers = players.update(firstPlayer, updatedPlayer);

        Players expectedPlayers = Players.of(
                asList(
                        updatedPlayer,
                        secondPlayer
                ),
                playersInput
        );
        assertThat(updatedPlayers).isEqualTo(expectedPlayers);
    }

    @Test
    void should_get_next_players() {
        Player firstPlayer = mock(Player.class);
        Player secondPlayer = mock(Player.class);
        Players players = Players.of(asList(firstPlayer, secondPlayer), playersInput);

        Players nextPlayers = players.nextPlayers();

        Players expectedPlayers = Players.of(asList(secondPlayer, firstPlayer), playersInput);
        assertThat(nextPlayers).isEqualTo(expectedPlayers);
    }

}