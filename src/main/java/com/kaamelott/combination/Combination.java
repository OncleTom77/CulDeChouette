package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Players;

public interface Combination {

    boolean match(Dice dice);

    int compute(Dice dice);

    default Players compute(Dice dice, Players players) {
        throw new UnsupportedOperationException();
    }
}
