package com.kaamelott.combination;

import com.kaamelott.Dice;

public interface Combination {

    boolean match(Dice dice);

    int compute(Dice dice);

    int compute(int value);
}
