package com.kaamelott.game;

import com.kaamelott.combination.Combination;
import com.kaamelott.combination.Combinations;
import com.kaamelott.dice.Dice;
import com.kaamelott.player.Players;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GameStateTest {

    @Test
    void should_has_next_state() {
        Players players = mock(Players.class);
        Combinations combinations = mock(Combinations.class);
        GameState gameState = GameState.of(players, combinations);

        when(players.hasSomeoneReached(anyInt())).thenReturn(true);

        boolean hasNext = gameState.hasNext();

        verify(players).hasSomeoneReached(anyInt());

        assertThat(hasNext).isFalse();
    }

    @Test
    void should_play_current_player_turn() {
        Dice dice = mock(Dice.class);
        Combination combination = mock(Combination.class);
        Players updatedPlayers = mock(Players.class);
        Players nextUpdatedPlayers = mock(Players.class);
        Players players = mock(Players.class);
        Combinations combinations = mock(Combinations.class);
        GameState gameState = GameState.of(players, combinations);

        when(players.roll()).thenReturn(dice);
        when(combinations.match(dice)).thenReturn(combination);
        when(combination.compute(dice, players)).thenReturn(updatedPlayers);
        when(updatedPlayers.nextPlayers()).thenReturn(nextUpdatedPlayers);

        GameState nextTurn = gameState.nextState();

        verify(players).roll();
        verify(combinations).match(dice);
        verify(combination).compute(dice, players);
        verify(updatedPlayers).nextPlayers();

        GameState expectedGameState = GameState.of(nextUpdatedPlayers, combinations);
        assertThat(nextTurn).isEqualTo(expectedGameState);
    }
}