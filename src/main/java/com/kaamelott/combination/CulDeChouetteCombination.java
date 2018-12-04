package com.kaamelott.combination;

import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CulDeChouetteCombination that = (CulDeChouetteCombination) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
