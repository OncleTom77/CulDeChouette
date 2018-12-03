package com.kaamelott;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

class CombinationCalculator {

    List<Combination> getCombinationsFrom(String roll) {
        List<Integer> digits = getDicesAsOrderedDigits(roll);
        List<Combination> combinations = new ArrayList<>();

        // TODO: Add Néant Combination !!

        Optional<CulDeChouetteCombination> culDeChouette = CulDeChouetteCombination.from(digits);
        Optional<ChouetteVeluteCombination> chouetteVelute = ChouetteVeluteCombination.from(digits);

        culDeChouette.ifPresent(combinations::add);
        chouetteVelute.ifPresent(combinations::add);
        SuiteCombination.from(digits).ifPresent(combinations::add);

        if (!chouetteVelute.isPresent()) {
            VeluteCombination.from(digits).ifPresent(combinations::add);

            if (!culDeChouette.isPresent()) {
                ChouetteCombination.from(digits).ifPresent(combinations::add);
            }
        }

        return combinations;
    }

    private List<Integer> getDicesAsOrderedDigits(String roll) {
        int firstDigit = Character.digit(roll.charAt(0), 10);
        int secondDigit = Character.digit(roll.charAt(1), 10);
        int thirdDigit = Character.digit(roll.charAt(2), 10);

        List<Integer> digits = asList(firstDigit, secondDigit, thirdDigit);
        digits.sort(Integer::compareTo);

        return digits;
    }

}
