package com.kaamelott;

import java.util.List;
import java.util.Optional;

class ChouetteCombination implements Combination {
    private int value;

    private ChouetteCombination(int value) {
        this.value = value;
    }

    static Combination from(int value) {
        return new ChouetteCombination(value);
    }

    static Optional<Combination> from(List<Integer> orderedDices) {
        if (orderedDices.get(1).equals(orderedDices.get(0))
                || orderedDices.get(1).equals(orderedDices.get(2))) {
            return Optional.of(new ChouetteCombination(orderedDices.get(1)));
        }

        return Optional.empty();
    }

    @Override
    public int compute() {
        return value * value;
    }
}
