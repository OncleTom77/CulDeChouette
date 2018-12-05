package com.kaamelott;

import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;
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
        diceRoller = mock(DiceRoller.class);
    }

    @Test
    void should_play_next_turn() {
        Dice dice = Dice.from("131");
        when(diceRoller.roll()).thenReturn(dice);

        Game game = Game.of(Players.of(asList(
                Player.of("Perceval", diceRoller),
                Player.of("Karadoc", diceRoller)
        )));

        Game nextState = game.nextTurn();

        Game expectedGame = Game.of(Players.of(asList(
                Player.of("Karadoc", 0, diceRoller),
                Player.of("Perceval", 1, diceRoller)
        )));
        assertThat(nextState).isEqualTo(expectedGame);
    }
}
