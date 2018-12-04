package com.kaamelott.combination;

import java.util.List;

public class NeantCombination implements Combination {

    NeantCombination() {
    }

    @Override
    public boolean match(List<Integer> orderedDices) {
        return true;
    }

    @Override
    public int compute(List<Integer> orderedDices) {
        return compute(0);
    }

    @Override
    public int compute(int value) {
        return 0;
    }
}
