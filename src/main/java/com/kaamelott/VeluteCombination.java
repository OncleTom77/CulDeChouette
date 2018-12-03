package com.kaamelott;

import java.util.List;
import java.util.Optional;

public class VeluteCombination implements Combination {

    private final int value;

    private VeluteCombination(int value) {
        this.value = value;
    }

    static Combination from(int value) {
        return new VeluteCombination(value);
    }

    static Optional<Combination> from(List<Integer> orderedDices) {
        if (orderedDices.get(0) + orderedDices.get(1) == orderedDices.get(2)) {
            return Optional.of(from(orderedDices.get(2)));
        }

        return Optional.empty();
    }

    @Override
    public int compute() {
        return value * value * 2;
    }
}
