package com.kaamelott.dice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Dice {

    private final List<Integer> orderedDice;

    private Dice(List<Integer> orderedDice) {
        this.orderedDice = orderedDice;
    }

    public static Dice from(String roll) {
        List<Integer> orderedDices = roll
                .chars()
                .map(digit -> Character.digit(digit, 10))
                .boxed()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        return new Dice(orderedDices);
    }

    public Integer first() {
        return orderedDice.get(0);
    }

    public Integer second() {
        return orderedDice.get(1);
    }

    public Integer third() {
        return orderedDice.get(2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return Objects.equals(orderedDice, dice.orderedDice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderedDice);
    }
}
