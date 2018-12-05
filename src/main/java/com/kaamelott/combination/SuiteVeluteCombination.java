package com.kaamelott.combination;

import com.kaamelott.Dice;

public class SuiteVeluteCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return dice.first() == 1
                && dice.second() == 2
                && dice.third() == 3;
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
