package com.kaamelott;

import java.util.List;
import java.util.stream.Collectors;

public class Dice {

    private final List<Integer> orderedDice;

    private Dice(List<Integer> orderedDice) {
        this.orderedDice = orderedDice;
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
        return orderedDice.get(0);
    }

    public Integer getSecond() {
        return orderedDice.get(1);
    }

    public Integer getThird() {
        return orderedDice.get(2);
    }
}
