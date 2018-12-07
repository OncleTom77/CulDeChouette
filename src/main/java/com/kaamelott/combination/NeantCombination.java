package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Players;

public class NeantCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return true;
    }

    @Override
    public Players compute(Dice dice, Players players) {
        return players;
    }
}
