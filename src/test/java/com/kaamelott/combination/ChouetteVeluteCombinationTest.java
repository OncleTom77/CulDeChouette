package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ChouetteVeluteCombinationTest {

    private Dice dice;

    @BeforeEach
    void setUp() {
        this.dice = mock(Dice.class);
    }

    @ParameterizedTest(name = "Chouette-Velute de {0} : {1}")
    @CsvSource(value = {
            "2, 8",
            "4, 32",
            "6, 72",
    })
    void should_compute_chouette_velute_combination_as_velute(int value, int expectedScore) {
        Players players = mock(Players.class);
        Player player = mock(Player.class);
        Player updatedPlayer = mock(Player.class);
        Players expectedPlayers = mock(Players.class);

        when(dice.third()).thenReturn(value);
        when(players.requestPlayer()).thenReturn(player);
        when(player.addScore(expectedScore)).thenReturn(updatedPlayer);
        when(players.update(player, updatedPlayer)).thenReturn(expectedPlayers);

        Players updatedPlayers = new ChouetteVeluteCombination().compute(dice, players);

        assertThat(updatedPlayers).isEqualTo(expectedPlayers);
    }

    @ParameterizedTest(name = "Chouette-Velute ({0})")
    @CsvSource(value = {
            "1, 1, 2",
            "2, 2, 4",
            "3, 3, 6",
    })
    void should_have_chouette_velute_combination_when_roll_represents_a_chouette_velute(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new ChouetteVeluteCombination().match(dice);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de Chouette-Velute ({0})")
    @CsvSource(value = {
            "1, 1, 3",
            "2, 2, 2",
            "2, 3, 4",
            "1, 4, 6",
    })
    void should_not_have_chouette_velute_combination_when_roll_does_not_represent_a_chouette_velute(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new ChouetteVeluteCombination().match(dice);

        assertThat(match).isFalse();
    }
}