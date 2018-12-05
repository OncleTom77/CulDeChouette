package com.kaamelott.combination;

import com.kaamelott.Dice;

public class CulDeChouetteCombination implements Combination {

    CulDeChouetteCombination() {
    }

    @Override
    public boolean match(Dice dice) {
        return dice.first().equals(dice.second())
                && dice.first().equals(dice.third());
    }

    @Override
    public int compute(Dice dice) {
        return compute(dice.first());
    }

    @Override
    public int compute(int value) {
        return 40 + value * 10;
    }
}
