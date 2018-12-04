package com.kaamelott.combination;

import com.kaamelott.Dice;

class ChouetteCombination implements Combination {

    ChouetteCombination() {
    }

    @Override
    public boolean match(Dice dice) {
        return dice.getSecond().equals(dice.getFirst())
                ^ dice.getSecond().equals(dice.getThird());
    }

    @Override
    public int compute(Dice dice) {
        return compute(dice.getSecond());
    }

    @Override
    public int compute(int value) {
        return value * value;
    }
}
