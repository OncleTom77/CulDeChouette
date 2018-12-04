package com.kaamelott.combination;

import com.kaamelott.Dices;

public class SuiteVeluteCombination implements Combination {

    @Override
    public boolean match(Dices dices) {
        return dices.getFirst() == 1
                && dices.getSecond() == 2
                && dices.getThird() == 3;
    }

    @Override
    public int compute(Dices dices) {
        return new VeluteCombination().compute(dices);
    }

    @Override
    public int compute(int value) {
        return new VeluteCombination().compute(value);
    }
}
