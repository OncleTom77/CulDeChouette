package com.kaamelott.combination;

import com.kaamelott.dice.Dice;

public class NeantCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return true;
    }

    @Override
    public int compute(Dice dice) {
        return 0;
    }

}
