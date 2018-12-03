package com.kaamelott;

import java.util.List;
import java.util.Optional;

public class CulDeChouetteCombination implements Combination {

    private final int value;

    private CulDeChouetteCombination(int value) {
        this.value = value;
    }

    static CulDeChouetteCombination from(int value) {
        return new CulDeChouetteCombination(value);
    }

    static Optional<CulDeChouetteCombination> from(List<Integer> orderedDices) {
        if (orderedDices.get(0).equals(orderedDices.get(1))
                && orderedDices.get(0).equals(orderedDices.get(2))) {
            return Optional.of(from(orderedDices.get(0)));
        }

        return Optional.empty();
    }

    @Override
    public int compute() {
        return 40 + value * 10;
    }
}
