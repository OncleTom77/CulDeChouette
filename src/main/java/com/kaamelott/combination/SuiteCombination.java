package com.kaamelott.combination;

import com.kaamelott.Dices;

public class SuiteCombination implements Combination {

    SuiteCombination() {
    }

    @Override
    public boolean match(Dices dices) {
        return dices.getFirst() == dices.getSecond() - 1
                && dices.getSecond() == dices.getThird() - 1;
    }

    @Override
    public int compute(Dices dices) {
        return compute(0);
    }

    @Override
    public int compute(int value) {
        return -10; // TODO: change that into action
    }
}
