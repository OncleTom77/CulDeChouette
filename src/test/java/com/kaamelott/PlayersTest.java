package com.kaamelott;

import com.kaamelott.dice.Dice;
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
}