package com.kaamelott.player;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PlayersTest {

    @Test
    void should_roll_current_player() {
        Player currentPlayer = mock(Player.class);
        Player nextPlayer = mock(Player.class);
        Dice expectedDice = mock(Dice.class);

        Players players = Players.of(asList(
                currentPlayer,
                nextPlayer
        ));

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
        Players players = Players.of(asList(firstPlayer, secondPlayer));
        Players expectedPlayers = Players.of(asList(secondPlayer, updatedFirstPlayer));

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
        Players players = Players.of(asList(firstPlayer, secondPlayer));

        when(firstPlayer.hasReached(score)).thenReturn(false);
        when(secondPlayer.hasReached(score)).thenReturn(true);

        boolean hasSomeoneReached = players.hasSomeoneReached(score);

        verify(firstPlayer).hasReached(score);
        verify(secondPlayer).hasReached(score);
        assertThat(hasSomeoneReached).isTrue();
    }
}