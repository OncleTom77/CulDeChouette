package com.kaamelott.combination;

import com.kaamelott.dice.Dice;

class ChouetteCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return dice.second().equals(dice.first())
                ^ dice.second().equals(dice.third());
    }

    @Override
    public int compute(Dice dice) {
        return dice.second() * dice.second();
    }

}
