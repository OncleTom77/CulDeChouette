package com.kaamelott.combination;

import com.kaamelott.dice.Dice;

import java.util.*;

import static java.util.Arrays.asList;

public class Combinations {

    private final List<Combination> combinations;

    private Combinations(List<Combination> combinations) {
        this.combinations = combinations;
    }

    static Combinations from(List<Combination> combinations) {
        return new Combinations(combinations);
    }

    public static Combinations useDefaults() {
        List<Combination> defaultCombinations = asList(
                new SuiteVeluteCombination(),
                new CulDeChouetteCombination(),
                new ChouetteVeluteCombination(),
                new SuiteCombination(),
                new VeluteCombination(),
                new ChouetteCombination(),
                new NeantCombination()
        );
        return from(defaultCombinations);
    }

    public Combination match(Dice dice) {
        return combinations
                .stream()
                .filter(combination -> combination.match(dice))
                .findFirst()
                .orElse(new NeantCombination());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combinations that = (Combinations) o;
        return Objects.equals(combinations, that.combinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(combinations);
    }
}
