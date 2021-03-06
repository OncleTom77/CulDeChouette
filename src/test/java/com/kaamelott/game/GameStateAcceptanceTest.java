package com.kaamelott.game;

import com.kaamelott.combination.Combinations;
import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;
import com.kaamelott.player.PlayersInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameStateAcceptanceTest {

    private DiceRoller diceRoller;
    private PlayersInput playersInput;

    @BeforeEach
    void setUp() {
        diceRoller = mock(DiceRoller.class);
        playersInput = mock(PlayersInput.class);
    }

    @Test
    void should_update_state_2() {
        Dice dice = Dice.from("234");
        when(diceRoller.roll()).thenReturn(dice);
        when(playersInput.read(anyString())).thenReturn("Karadoc");

        Combinations combinations = Combinations.useDefaults();

        GameState gameState = GameState.of(
                Players.of(
                        asList(
                                Player.of("Perceval", 25, diceRoller),
                                Player.of("Karadoc", 25, diceRoller)
                        ),
                        playersInput
                ),
                combinations
        );

        GameState nextState = gameState.nextState();

        GameState expectedGameState = GameState.of(
                Players.of(
                        asList(
                                Player.of("Karadoc", 15, diceRoller),
                                Player.of("Perceval", 25, diceRoller)
                        ),
                        playersInput
                ),
                combinations
        );
        assertThat(nextState).isEqualTo(expectedGameState);
    }
}
