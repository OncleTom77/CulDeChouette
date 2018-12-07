package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SuiteVeluteCombinationTest {

    private Dice dice;
    private VeluteCombination veluteCombination;
    private SuiteCombination suiteCombination;

    @BeforeEach
    void setUp() {
        dice = mock(Dice.class);
        veluteCombination = mock(VeluteCombination.class);
        suiteCombination = mock(SuiteCombination.class);
    }

    @Test
    void should_compute_suite_velute_combination_as_a_computation_of_a_velute_then_a_suite() {
        Players players = mock(Players.class);
        Players updatedPlayersAfterVelute = mock(Players.class);
        Players updatedPlayersAfterSuite = mock(Players.class);

        when(veluteCombination.compute(dice, players)).thenReturn(updatedPlayersAfterVelute);
        when(suiteCombination.compute(dice, updatedPlayersAfterVelute)).thenReturn(updatedPlayersAfterSuite);

        Players score = new SuiteVeluteCombination(veluteCombination, suiteCombination).compute(dice, players);

        assertThat(score).isEqualTo(updatedPlayersAfterSuite);
    }

    @ParameterizedTest(name = "SuiteVelute ({0})")
    @CsvSource(value = {
            "1, 2, 3",
    })
    void should_have_suite_velute_combination_when_roll_represents_a_suite_and_a_velute(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new SuiteVeluteCombination(veluteCombination, suiteCombination).match(dice);

        assertThat(match).isTrue();
    }

    @ParameterizedTest(name = "Pas de SuiteVelute ({0})")
    @CsvSource(value = {
            "1, 1, 1",
            "2, 4, 5",
            "2, 6, 6",
            "2, 3, 4",
            "2, 3, 5",
    })
    void should_not_have_velute_combination_when_roll_does_not_represent_a_velute(int first, int second, int third) {
        when(dice.first()).thenReturn(first);
        when(dice.second()).thenReturn(second);
        when(dice.third()).thenReturn(third);

        boolean match = new SuiteVeluteCombination(veluteCombination, suiteCombination).match(dice);

        assertThat(match).isFalse();
    }
}