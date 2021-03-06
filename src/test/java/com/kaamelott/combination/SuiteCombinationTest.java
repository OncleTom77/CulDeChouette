package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class SuiteCombinationTest {

    private SuiteCombination combination;
    private Dice dice;

    @BeforeEach
    void setUp() {
        dice = mock(Dice.class);
        combination = new SuiteCombination();
    }

    @Test
    void should_compute_the_updated_score_of_the_inputted_player() {
        Players players = mock(Players.class);
        Players updatedPlayers = mock(Players.class);
        Player player = mock(Player.class);
        Player updatedPlayer = mock(Player.class);

        when(players.requestPlayer(anyString())).thenReturn(player);
        when(player.addScore(anyInt())).thenReturn(updatedPlayer);
        when(players.update(player, updatedPlayer)).thenReturn(updatedPlayers);

        Players computedPlayers = combination.compute(dice, players);

        verify(player).addScore(-10);
        assertThat(computedPlayers).isEqualTo(updatedPlayers);
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "1, 2, 3",
            "2, 3, 4",
            "3, 4, 5",
            "4, 5, 6",
    })
    void should_have_suite_combination_when_roll_represents_a_suite(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = combination.match(dice);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "1, 1, 6",
            "3, 3, 3",
            "2, 3, 5",
            "1, 3, 6",
    })
    void should_not_have_suite_combination_when_roll_does_not_represent_a_suite(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = combination.match(dice);

        assertThat(match).isFalse();
    }
}