package com.kaamelott.combination;

import com.kaamelott.Dice;

public class ChouetteVeluteCombination implements Combination {

    private final ChouetteCombination chouetteCombination;
    private final VeluteCombination veluteCombination;

    ChouetteVeluteCombination() {
        chouetteCombination = new ChouetteCombination();
        veluteCombination = new VeluteCombination();
    }

    @Override
    public boolean match(Dice dice) {
        return chouetteCombination.match(dice)
                && veluteCombination.match(dice);
    }

    @Override
    public int compute(Dice dice) {
        return veluteCombination.compute(dice);
    }
}
