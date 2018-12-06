package com.kaamelott.game;

import com.kaamelott.combination.Combinations;
import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;
import com.kaamelott.game.Game;
import com.kaamelott.game.GameState;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameAcceptanceTest {

    private DiceRoller diceRoller;

    @BeforeEach
    void setUp() {
        this.diceRoller = mock(DiceRoller.class);
    }

    @Test
    void should_stop_game_when_a_player_reaches_max_score() {
        Players players = Players.of(asList(
                Player.of("Perceval", diceRoller),
                Player.of("Karadoc", diceRoller)
        ));
        Combinations combinations = Combinations.useDefaults();
        GameState state = GameState.of(players, combinations);
        Game game = Game.of(state);

        when(diceRoller.roll()).thenReturn(
                Dice.from("666"),
                Dice.from("135"),
                Dice.from("666"),
                Dice.from("114"),
                Dice.from("666"),
                Dice.from("554"),
                Dice.from("246")
        );

        game.play();

        Players expectedPlayers = Players.of(asList(
                Player.of("Karadoc", 26, diceRoller),
                Player.of("Perceval", 372, diceRoller)
        ));
        GameState expectedState = GameState.of(expectedPlayers, combinations);
        Game expectedGame = Game.of(expectedState);
        assertThat(game).isEqualTo(expectedGame);
    }
}
