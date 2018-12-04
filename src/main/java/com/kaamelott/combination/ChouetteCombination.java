package com.kaamelott.combination;

import com.kaamelott.Dices;

class ChouetteCombination implements Combination {

    ChouetteCombination() {
    }

    @Override
    public boolean match(Dices dices) {
        return dices.getSecond().equals(dices.getFirst())
                ^ dices.getSecond().equals(dices.getThird());
    }

    @Override
    public int compute(Dices dices) {
        return compute(dices.getSecond());
    }

    @Override
    public int compute(int value) {
        return value * value;
    }
}
