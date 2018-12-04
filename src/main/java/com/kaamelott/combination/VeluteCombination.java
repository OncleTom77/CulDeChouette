package com.kaamelott.combination;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class VeluteCombination implements Combination {

    private final int value;

    private VeluteCombination(int value) {
        this.value = value;
    }

    static VeluteCombination from(int value) {
        return new VeluteCombination(value);
    }

    static Optional<VeluteCombination> from(List<Integer> orderedDices) {
        if (orderedDices.get(0) + orderedDices.get(1) == orderedDices.get(2)) {
            return Optional.of(from(orderedDices.get(2)));
        }

        return Optional.empty();
    }

    @Override
    public int compute() {
        return value * value * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeluteCombination that = (VeluteCombination) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
