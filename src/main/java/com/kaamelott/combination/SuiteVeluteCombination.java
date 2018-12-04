package com.kaamelott.combination;

import com.kaamelott.Dice;

public class SuiteVeluteCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return dice.getFirst() == 1
                && dice.getSecond() == 2
                && dice.getThird() == 3;
    }

    @Override
    public int compute(Dice dice) {
        return new VeluteCombination().compute(dice);
    }

    @Override
    public int compute(int value) {
        return new VeluteCombination().compute(value);
    }
}
