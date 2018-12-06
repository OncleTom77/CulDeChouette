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

class ChouetteCombinationTest {

    private Dice dice;

    @BeforeEach
    void setUp() {
        dice = mock(Dice.class);
    }

    @ParameterizedTest(name = "Chouette de {0} : {1}")
    @CsvSource(value = {
            "1, 1",
            "2, 4",
            "3, 9",
            "4, 16",
            "5, 25",
            "6, 36",
    })
    void should_compute_chouette_combination_as_the_power_of_2_of_the_value_on_the_identical_dices(int value, int expectedScore) {
        Players players = mock(Players.class);
        Player player = mock(Player.class);
        Player updatedPlayer = mock(Player.class);
        Players expectedPlayers = mock(Players.class);

        when(dice.second()).thenReturn(value);
        when(players.currentPlayer()).thenReturn(player);
        when(player.addScore(expectedScore)).thenReturn(updatedPlayer);
        when(players.update(player, updatedPlayer)).thenReturn(expectedPlayers);

        Players updatedPlayers = new ChouetteCombination().compute(dice, players);

        assertThat(updatedPlayers).isEqualTo(expectedPlayers);
    }

    @ParameterizedTest(name = "Chouette de {index} : {0}")
    @CsvSource(value = {
            "1, 1, 3",
            "2, 2, 5",
            "3, 3, 4",
            "4, 4, 6",
            "1, 5, 5",
            "5, 6, 6",
    })
    void should_have_chouette_combination_when_roll_represents_a_chouette(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new ChouetteCombination().match(dice);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de Chouette ({0})")
    @CsvSource(value = {
            "1, 1, 1",
            "1, 2, 3",
            "5, 3, 6",
    })
    void should_not_have_chouette_combination_when_roll_does_not_represent_a_chouette(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new ChouetteCombination().match(dice);

        assertThat(match).isFalse();
    }
}
