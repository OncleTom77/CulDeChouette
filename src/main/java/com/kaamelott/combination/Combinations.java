package com.kaamelott.combination;

import com.kaamelott.dice.Dice;

import java.util.*;

class Combinations {

    private final List<Combination> combinations;

    private Combinations(List<Combination> combinations) {
        this.combinations = combinations;
    }

    static Combinations from(List<Combination> combinations) {
        return new Combinations(combinations);
    }

    Combination match(Dice dice) {
        return combinations
                .stream()
                .filter(combination -> combination.match(dice))
                .findFirst()
                .orElse(new NeantCombination());
    }
}
