package com.kaamelott.combination;

import com.kaamelott.Dice;

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
