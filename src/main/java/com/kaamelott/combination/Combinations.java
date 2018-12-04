package com.kaamelott.combination;

import com.kaamelott.Dices;

import java.util.*;

class Combinations {

    private final Map<Integer, List<Combination>> combinationSet;

    private Combinations(Map<Integer, List<Combination>> combinationSet) {
        this.combinationSet = combinationSet;
    }

    static Combinations from(Map<Integer, List<Combination>> combinationSet) {
        return new Combinations(combinationSet);
    }

    Combination match(Dices dices) {
        List<Integer> reverseSortedKeys = new ArrayList<>(combinationSet.keySet());
        reverseSortedKeys.sort(Comparator.reverseOrder());

        return reverseSortedKeys.stream()
                .map(combinationSet::get)
                .flatMap(Collection::stream)
                .filter(combination -> combination.match(dices))
                .findFirst()
                .orElse(new NeantCombination());
    }
}
