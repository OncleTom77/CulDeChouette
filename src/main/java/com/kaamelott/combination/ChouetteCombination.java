package com.kaamelott.combination;

import com.kaamelott.Dice;

class ChouetteCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return dice.second().equals(dice.first())
                ^ dice.second().equals(dice.third());
    }

    @Override
    public int compute(Dice dice) {
        return compute(dice.second());
    }

    @Override
    public int compute(int value) {
        return value * value;
    }
}
