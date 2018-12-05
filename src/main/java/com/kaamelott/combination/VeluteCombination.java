package com.kaamelott.combination;

import com.kaamelott.Dice;

public class VeluteCombination implements Combination {

    VeluteCombination() {
    }

    @Override
    public boolean match(Dice dice) {
        return dice.first() + dice.second() == dice.third();
    }

    @Override
    public int compute(Dice dice) {
        return compute(dice.third());
    }

    @Override
    public int compute(int value) {
        return value * value * 2;
    }
}
