package com.kaamelott;

import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerTest {

    private DiceRoller diceRoller;
    private Player player;

    @BeforeEach
    void setUp() {
        diceRoller = mock(DiceRoller.class);
        player = Player.of("Perceval", diceRoller);
    }

    @Test
    void should_roll() {
        Dice dice = mock(Dice.class);
        when(diceRoller.roll()).thenReturn(dice);

        Dice rolled = player.roll();

        assertThat(rolled).isEqualTo(dice);
    }

    @Test
    void should_update_score() {
        int score = 1;

        Player updatedPlayer = player.updateScore(score);

        Player expectedPlayer = Player.of("Perceval", 1, diceRoller);
        assertThat(updatedPlayer).isEqualTo(expectedPlayer);
    }

    @ParameterizedTest(name = "Score {0} : {1}")
    @CsvSource({
            "342, false",
            "343, true",
            "344, true"
    })
    void should_has_not_reached_score(int score, boolean expectedResult) {
        Player player = Player.of("toto", score, diceRoller);

        boolean hasReached = player.hasReached(343);

        assertThat(hasReached).isEqualTo(expectedResult);
    }
}
