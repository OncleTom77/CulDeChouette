package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

class CulDeChouetteCombinationTest {

    private Dice dice;

    @BeforeEach
    void setUp() {
        dice = mock(Dice.class);
    }

    @ParameterizedTest(name = "Cul de Chouette de {0} : {1}")
    @CsvSource(value = {
            "1, 50",
            "2, 60",
            "3, 70",
            "4, 80",
            "5, 90",
            "6, 100",
    })
    void should_compute_cul_de_chouette_combination_as_40_plus_number_on_dices_multiply_by_10(int value, int expectedScore) {
        Players players = mock(Players.class);
        Player player = mock(Player.class);
        Player updatedPlayer = mock(Player.class);
        Players expectedPlayers = mock(Players.class);

        when(dice.first()).thenReturn(value);
        when(players.currentPlayer()).thenReturn(player);
        when(player.addScore(anyInt())).thenReturn(updatedPlayer);
        when(players.update(player, updatedPlayer)).thenReturn(expectedPlayers);

        Players updatedPlayers = new CulDeChouetteCombination().compute(dice, players);

        verify(player).addScore(expectedScore);
        assertThat(updatedPlayers).isEqualTo(expectedPlayers);
    }

    @ParameterizedTest(name = "Cul de Chouette de {index} : {0}")
    @CsvSource(value = {
            "1, 1, 1",
            "2, 2, 2",
            "3, 3, 3",
            "4, 4, 4",
            "5, 5, 5",
            "6, 6, 6",
    })
    void should_have_cul_de_chouette_combination_when_roll_represents_a_cul_de_chouette(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new CulDeChouetteCombination().match(dice);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de Cul de Chouette ({0})")
    @CsvSource(value = {
            "1, 1, 2",
            "1, 4, 5",
            "4, 5, 6",
            "1, 3, 5",
    })
    void should_not_have_cul_de_chouette_combination_when_roll_does_not_represent_a_cul_de_chouette(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new CulDeChouetteCombination().match(dice);

        assertThat(match).isFalse();
    }
}