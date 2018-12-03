package com.kaamelott;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

class CombinationCalculator {
    int computeScore(String roll) {
        List<Integer> digits = getDicesAsOrderedDigits(roll);

        boolean hasSuite = hasSuite(digits);
        Optional<Integer> hasCulDeChouette = hasCulDeChouette(digits);
        Optional<Integer> hasChouette = hasChouette(digits);
        Optional<Integer> hasVelute = hasVelute(digits);

        if (hasSuite
                && !hasVelute.isPresent()) {
            return -10;
        }

        if (hasCulDeChouette.isPresent()) {
            return hasCulDeChouette.get();
        }

        if (hasChouette.isPresent()
                && hasVelute.isPresent()) {
            return hasVelute.get();
        }

        if (hasVelute.isPresent()) {
            return hasVelute.get();
        }

        if (hasChouette.isPresent()) {
            return hasChouette.get();
        }

        return 0;
    }

    private boolean hasSuite(List<Integer> digits) {
        return digits.get(0) == digits.get(1) - 1
                && digits.get(1) == digits.get(2) - 1;
    }

    private Optional<Integer> hasCulDeChouette(List<Integer> digits) {
        if (digits.get(0).equals(digits.get(1))
                && digits.get(0).equals(digits.get(2)))
            return Optional.of(40 + digits.get(0) * 10);
        return Optional.empty();
    }

    private List<Integer> getDicesAsOrderedDigits(String roll) {
        int firstDigit = Character.digit(roll.charAt(0), 10);
        int secondDigit = Character.digit(roll.charAt(1), 10);
        int thirdDigit = Character.digit(roll.charAt(2), 10);

        List<Integer> digits = asList(firstDigit, secondDigit, thirdDigit);
        digits.sort(Integer::compareTo);

        return digits;
    }

    private Optional<Integer> hasVelute(List<Integer> digits) {
        Optional<Integer> hasVelute = Optional.empty();

        if (digits.get(0) + digits.get(1) == digits.get(2)) {
            hasVelute = Optional.of(digits.get(2) * digits.get(2) * 2);
        }

        return hasVelute;
    }

    private Optional<Integer> hasChouette(List<Integer> digits) {
        Optional<Integer> hasChouette = Optional.empty();

        if (digits.get(1).equals(digits.get(0))
                || digits.get(1).equals(digits.get(2))) {
            hasChouette = Optional.of(digits.get(1) * digits.get(1));
        }

        return hasChouette;
    }
}
