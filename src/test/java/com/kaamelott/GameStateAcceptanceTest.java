package com.kaamelott;

import com.kaamelott.combination.Combinations;
import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameStateAcceptanceTest {

    private DiceRoller diceRoller;

    @BeforeEach
    void setUp() {
        diceRoller = mock(DiceRoller.class);
    }

    @Test
    void should_play_next_turn() {
        Dice dice = Dice.from("131");
        when(diceRoller.roll()).thenReturn(dice);

        Combinations combinations = Combinations.useDefaults();
        GameState gameState = GameState.of(
                Players.of(asList(
                        Player.of("Perceval", diceRoller),
                        Player.of("Karadoc", diceRoller)
                )),
                combinations
        );

        GameState nextState = gameState.nextTurn();

        GameState expectedGameState = GameState.of(
                Players.of(asList(
                        Player.of("Karadoc", 0, diceRoller),
                        Player.of("Perceval", 1, diceRoller)
                )),
                combinations
        );
        assertThat(nextState).isEqualTo(expectedGameState);
    }

    @Test
    void should_stop_game_when_a_player_reaches_max_score() {
        when(diceRoller.roll()).thenReturn(
                Dice.from("666"),
                Dice.from("122"),
                Dice.from("666"),
                Dice.from("111"),
                Dice.from("666"),
                Dice.from("135"),
                Dice.from("246")
        );

        Combinations combinations = Combinations.useDefaults();
        GameState gameState = GameState.of(
                Players.of(asList(
                        Player.of("Perceval", diceRoller),
                        Player.of("Karadoc", diceRoller)
                )),
                combinations
        );

        GameState finalState = gameState.play();

        GameState expectedGameState = GameState.of(
                Players.of(asList(
                        Player.of("Karadoc", 0, diceRoller),
                        Player.of("Perceval", 372, diceRoller)
                )),
                combinations
        );
        assertThat(finalState).isEqualTo(expectedGameState);
    }
}
