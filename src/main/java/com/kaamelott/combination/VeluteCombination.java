package com.kaamelott.combination;

import com.kaamelott.Dices;

public class VeluteCombination implements Combination {

    VeluteCombination() {
    }

    @Override
    public boolean match(Dices dices) {
        return dices.getFirst() + dices.getSecond() == dices.getThird();
    }

    @Override
    public int compute(Dices dices) {
        return compute(dices.getThird());
    }

    @Override
    public int compute(int value) {
        return value * value * 2;
    }
}
