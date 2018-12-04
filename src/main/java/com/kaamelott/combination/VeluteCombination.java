package com.kaamelott.combination;

import com.kaamelott.Dice;

public class VeluteCombination implements Combination {

    VeluteCombination() {
    }

    @Override
    public boolean match(Dice dice) {
        return dice.getFirst() + dice.getSecond() == dice.getThird();
    }

    @Override
    public int compute(Dice dice) {
        return compute(dice.getThird());
    }

    @Override
    public int compute(int value) {
        return value * value * 2;
    }
}
