package com.kaamelott.combination;

public class NeantCombination implements Combination {

    private NeantCombination() {
    }

    static NeantCombination from() {
        return new NeantCombination();
    }

    @Override
    public int compute() {
        return 0;
    }
}
