package com.kaamelott.combination;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

class ChouetteCombination implements Combination {

    private final int value;

    private ChouetteCombination(int value) {
        this.value = value;
    }

    static ChouetteCombination from(int value) {
        return new ChouetteCombination(value);
    }

    static Optional<ChouetteCombination> from(List<Integer> orderedDices) {
        if (orderedDices.get(1).equals(orderedDices.get(0))
                 ^ orderedDices.get(1).equals(orderedDices.get(2))) {
            return Optional.of(from(orderedDices.get(1)));
        }

        return Optional.empty();
    }

    @Override
    public int compute() {
        return value * value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChouetteCombination that = (ChouetteCombination) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
