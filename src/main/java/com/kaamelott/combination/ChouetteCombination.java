package com.kaamelott.combination;

import java.util.List;

class ChouetteCombination implements Combination {

    ChouetteCombination() {
    }

    @Override
    public boolean match(List<Integer> orderedDices) {
        return orderedDices.get(1).equals(orderedDices.get(0))
                 ^ orderedDices.get(1).equals(orderedDices.get(2));
    }

    @Override
    public int compute(List<Integer> orderedDices) {
        return compute(orderedDices.get(1));
    }

    @Override
    public int compute(int value) {
        return value * value;
    }
}
