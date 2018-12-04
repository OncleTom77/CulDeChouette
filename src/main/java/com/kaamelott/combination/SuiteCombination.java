package com.kaamelott.combination;

import java.util.List;

public class SuiteCombination implements Combination {

    SuiteCombination() {
    }

    @Override
    public boolean match(List<Integer> orderedDices) {
        return orderedDices.get(0) == orderedDices.get(1) - 1
                && orderedDices.get(1) == orderedDices.get(2) - 1;
    }

    @Override
    public int compute(List<Integer> orderedDices) {
        return compute(0);
    }

    @Override
    public int compute(int value) {
        return -10; // TODO: change that into action
    }
}
