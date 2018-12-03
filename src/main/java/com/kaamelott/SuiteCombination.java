package com.kaamelott;

import java.util.List;
import java.util.Optional;

public class SuiteCombination implements Combination {

    private SuiteCombination() {
    }

    static SuiteCombination from() {
        return new SuiteCombination();
    }

    static Optional<SuiteCombination> from(List<Integer> orderedDices) {
        if (orderedDices.get(0) == orderedDices.get(1) - 1
                && orderedDices.get(1) == orderedDices.get(2) - 1) {
            return Optional.of(new SuiteCombination());
        }

        return Optional.empty();
    }

    @Override
    public int compute() {
        return -10;
    }
}
