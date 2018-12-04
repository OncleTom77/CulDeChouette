package com.kaamelott.combination;

import java.util.List;

public class CulDeChouetteCombination implements Combination {

    CulDeChouetteCombination() {
    }

    @Override
    public boolean match(List<Integer> orderedDices) {
        return orderedDices.get(0).equals(orderedDices.get(1))
                && orderedDices.get(0).equals(orderedDices.get(2));
    }

    @Override
    public int compute(List<Integer> orderedDices) {
        return compute(orderedDices.get(0));
    }

    @Override
    public int compute(int value) {
        return 40 + value * 10;
    }
}
