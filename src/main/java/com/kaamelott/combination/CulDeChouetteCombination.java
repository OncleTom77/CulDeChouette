package com.kaamelott.combination;

import com.kaamelott.Dice;

public class CulDeChouetteCombination implements Combination {

    CulDeChouetteCombination() {
    }

    @Override
    public boolean match(Dice dice) {
        return dice.getFirst().equals(dice.getSecond())
                && dice.getFirst().equals(dice.getThird());
    }

    @Override
    public int compute(Dice dice) {
        return compute(dice.getFirst());
    }

    @Override
    public int compute(int value) {
        return 40 + value * 10;
    }
}
