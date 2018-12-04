package com.kaamelott.combination;

import com.kaamelott.Dice;

public class NeantCombination implements Combination {

    NeantCombination() {
    }

    @Override
    public boolean match(Dice dice) {
        return true;
    }

    @Override
    public int compute(Dice dice) {
        return compute(0);
    }

    @Override
    public int compute(int value) {
        return 0;
    }
}
