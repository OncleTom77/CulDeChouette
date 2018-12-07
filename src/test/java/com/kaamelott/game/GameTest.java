package com.kaamelott.game;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameTest {

    @Test
    void should_stop_game_when_there_is_no_next_state() {
        GameState gameState1 = mock(GameState.class);
        GameState gameState2 = mock(GameState.class);

        Game game = Game.of(gameState1);

        when(gameState1.nextState()).thenReturn(gameState2);
        when(gameState1.hasNext()).thenReturn(true);
        when(gameState2.hasNext()).thenReturn(false);

        game.play();

        verify(gameState1).nextState();
        verify(gameState2, never()).nextState();
        verify(gameState1).hasNext();
        verify(gameState2).hasNext();
    }
}
