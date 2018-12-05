package com.kaamelott;

import com.kaamelott.dice.Dice;
import com.kaamelott.dice.DiceRoller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerTest {

    private DiceRoller diceRoller;
    private Player player;

    @BeforeEach
    void setUp() {
        diceRoller = mock(DiceRoller.class);
        player = Player.of(diceRoller);
    }

    @Test
    void should_roll() {
        Dice dice = mock(Dice.class);
        when(diceRoller.roll()).thenReturn(dice);

        Dice rolled = player.roll();

        assertThat(rolled).isEqualTo(dice);
    }
}
