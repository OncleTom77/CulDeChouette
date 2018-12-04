package com.kaamelott.combination;

import com.kaamelott.Dice;

public class SuiteCombination implements Combination {

    SuiteCombination() {
    }

    @Override
    public boolean match(Dice dice) {
        return dice.getFirst() == dice.getSecond() - 1
                && dice.getSecond() == dice.getThird() - 1;
    }

    @Override
    public int compute(Dice dice) {
        return compute(0);
    }

    @Override
    public int compute(int value) {
        return -10; // TODO: change that into action
    }
}
