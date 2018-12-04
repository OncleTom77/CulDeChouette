package com.kaamelott.combination;

import com.kaamelott.Dices;

public interface Combination {

    boolean match(Dices dices);

    int compute(Dices dices);

    int compute(int value);
}
