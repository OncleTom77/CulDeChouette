package com.kaamelott.combination;

import com.kaamelott.Dices;

public class NeantCombination implements Combination {

    NeantCombination() {
    }

    @Override
    public boolean match(Dices dices) {
        return true;
    }

    @Override
    public int compute(Dices dices) {
        return compute(0);
    }

    @Override
    public int compute(int value) {
        return 0;
    }
}
