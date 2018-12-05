package com.kaamelott.combination;

import com.kaamelott.Dice;

public class VeluteCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return dice.first() + dice.second() == dice.third();
    }

    @Override
    public int compute(Dice dice) {
        return dice.third() * dice.third() * 2;
    }

}
