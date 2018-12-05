package com.kaamelott.combination;

import com.kaamelott.dice.Dice;

public interface Combination {

    boolean match(Dice dice);

    int compute(Dice dice);
}
