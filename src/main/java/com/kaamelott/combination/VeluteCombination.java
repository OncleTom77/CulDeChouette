package com.kaamelott.combination;

import java.util.List;

public class VeluteCombination implements Combination {

    VeluteCombination() {
    }

    @Override
    public boolean match(List<Integer> orderedDices) {
        return orderedDices.get(0) + orderedDices.get(1) == orderedDices.get(2);
    }

    @Override
    public int compute(List<Integer> orderedDices) {
        return compute(orderedDices.get(2));
    }

    @Override
    public int compute(int value) {
        return value * value * 2;
    }
}
