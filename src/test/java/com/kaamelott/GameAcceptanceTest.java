package com.kaamelott;

import com.kaamelott.combination.Combination;
import com.kaamelott.combination.Combinations;
import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void should_toto() {
        List<Player> players = asList(
                Player.of("Perceval", diceRoller),
                Player.of("Karadoc", diceRoller)
        );
        Dice dice = Dice.from("131");

        when(diceRoller.roll()).thenReturn(dice);
        Game game = Game.of(players);

        Game nextState = game.nextTurn();

        assertThat(nextState).isEqualTo(Game.of(
                asList(
                        Player.of("Karadoc", 0, diceRoller),
                        Player.of("Perceval", 1, diceRoller)
                )
        ));
    }
}
