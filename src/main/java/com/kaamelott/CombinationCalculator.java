package com.kaamelott;

class CombinationCalculator {
    int computeScore(String roll) {
        for (int i = 1; i < 7; i++) {
            if (has2DicesOf(roll, i)) {
                return i*i;
            }
        }
        return 0;
    }

    private boolean has2DicesOf(String roll, int digit) {
        long nbDicesOfDigit = roll
                .chars()
                .filter(dice -> dice == Character.forDigit(digit, 10))
                .count();
        return nbDicesOfDigit == 2;
    }

}
