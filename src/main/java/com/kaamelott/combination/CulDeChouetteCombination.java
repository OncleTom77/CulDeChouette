package com.kaamelott.combination;

import com.kaamelott.Dices;

public class CulDeChouetteCombination implements Combination {

    CulDeChouetteCombination() {
    }

    @Override
    public boolean match(Dices dices) {
        return dices.getFirst().equals(dices.getSecond())
                && dices.getFirst().equals(dices.getThird());
    }

    @Override
    public int compute(Dices dices) {
        return compute(dices.getFirst());
    }

    @Override
    public int compute(int value) {
        return 40 + value * 10;
    }
}
