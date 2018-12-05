package com.kaamelott.combination;

import com.kaamelott.dice.Dice;

public class CulDeChouetteCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return dice.first().equals(dice.second())
                && dice.first().equals(dice.third());
    }

    @Override
    public int compute(Dice dice) {
        return 40 + dice.first() * 10;
    }

}
