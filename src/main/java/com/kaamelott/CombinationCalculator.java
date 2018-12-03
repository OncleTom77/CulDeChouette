package com.kaamelott;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

class CombinationCalculator {
    int computeScore(String roll) {
        Optional<Integer> hasVelute = hasVelute(roll);
        if (hasVelute.isPresent()) {
            return hasVelute.get();
        }

        Optional<Integer> hasChouette = hasChouette(roll);
        if (hasChouette.isPresent()) {
            return hasChouette.get();
        }

        return 0;
    }

    private Optional<Integer> hasVelute(String roll) {
        int firstDigit = Character.digit(roll.charAt(0), 10);
        int secondDigit = Character.digit(roll.charAt(1), 10);
        int thirdDigit = Character.digit(roll.charAt(2), 10);

        List<Integer> digits = asList(firstDigit, secondDigit, thirdDigit);
        digits.sort(Integer::compareTo);

        Optional<Integer> hasVelute = Optional.empty();
        if (digits.get(0) + digits.get(1) == digits.get(2)) {
            hasVelute = Optional.of(digits.get(2) * digits.get(2) * 2);
        }

        return hasVelute;
    }

    private Optional<Integer> hasChouette(String roll) {
        Optional<Integer> hasChouette = Optional.empty();
        for (int i = 1; i < 7; i++) {
            if (has2DicesOf(roll, i)) {
                hasChouette = Optional.of(i*i);
            }
        }
        return hasChouette;
    }

    private boolean has2DicesOf(String roll, int digit) {
        long nbDicesOfDigit = roll
                .chars()
                .filter(dice -> dice == Character.forDigit(digit, 10))
                .count();
        return nbDicesOfDigit == 2;
    }

}
