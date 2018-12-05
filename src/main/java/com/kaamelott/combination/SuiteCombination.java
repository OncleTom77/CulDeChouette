package com.kaamelott.combination;

import com.kaamelott.dice.Dice;

public class SuiteCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return dice.first() == dice.second() - 1
                && dice.second() == dice.third() - 1;
    }

    @Override
    public int compute(Dice dice) {
        return -10; // TODO: change that into action
    }
}
