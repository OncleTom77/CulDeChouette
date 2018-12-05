package com.kaamelott;

import com.kaamelott.combination.Combination;
import com.kaamelott.combination.Combinations;
import com.kaamelott.dice.Dice;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GameStateTest {

    @Test
    void should_play_current_player_turn() {
        Dice dice = mock(Dice.class);
        Combination combination = mock(Combination.class);
        int score = 0;
        Players updatedPlayers = mock(Players.class);
        Players players = mock(Players.class);
        Combinations combinations = mock(Combinations.class);
        GameState gameState = GameState.of(players, combinations);

        when(players.roll()).thenReturn(dice);
        when(combinations.match(dice)).thenReturn(combination);
        when(combination.compute(dice)).thenReturn(score);
        when(players.updateScore(score)).thenReturn(updatedPlayers);

        GameState nextTurn = gameState.nextTurn();

        verify(players).roll();
        verify(combinations).match(dice);
        verify(combination).compute(dice);
        verify(players).updateScore(score);

        GameState expectedGameState = GameState.of(updatedPlayers, combinations);
        assertThat(nextTurn).isEqualTo(expectedGameState);
    }
}