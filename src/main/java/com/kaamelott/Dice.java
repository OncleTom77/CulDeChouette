package com.kaamelott;

import java.util.List;
import java.util.stream.Collectors;

public class Dice {

    private final List<Integer> orderedDices;

    private Dice(List<Integer> orderedDices) {
        this.orderedDices = orderedDices;
    }

    public static Dice from(String roll) {
        List<Integer> orderedDices = roll.chars()
            .map(digit -> Character.digit(digit, 10))
            .boxed()
            .sorted(Integer::compareTo)
            .collect(Collectors.toList());

        return new Dice(orderedDices);
    }

    public Integer getFirst() {
        return orderedDices.get(0);
    }

    public Integer getSecond() {
        return orderedDices.get(1);
    }

    public Integer getThird() {
        return orderedDices.get(2);
    }
}
