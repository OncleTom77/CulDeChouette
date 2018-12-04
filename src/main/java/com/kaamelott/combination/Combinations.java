package com.kaamelott.combination;

import java.util.*;
import java.util.stream.Collectors;

class Combinations {

    private final Map<Integer, List<Combination>> combinationSet;

    private Combinations(Map<Integer, List<Combination>> combinationSet) {
        this.combinationSet = combinationSet;
    }

    static Combinations from(Map<Integer, List<Combination>> combinationSet) {
        return new Combinations(combinationSet);
    }

    Combination match(String roll) {
        List<Integer> orderedDices = roll.chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        return match(orderedDices);
    }

    private Combination match(List<Integer> orderedDices) {
        List<Integer> reverseSortedKeys = new ArrayList<>(combinationSet.keySet());
        reverseSortedKeys.sort(Comparator.reverseOrder());

        return reverseSortedKeys.stream()
                .map(combinationSet::get)
                .flatMap(Collection::stream)
                .filter(combination -> combination.match(orderedDices))
                .findFirst()
                .orElse(new NeantCombination());
    }
}
