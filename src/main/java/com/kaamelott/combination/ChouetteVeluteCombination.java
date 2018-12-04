package com.kaamelott.combination;

import com.kaamelott.Dices;

public class ChouetteVeluteCombination implements Combination {

    private final ChouetteCombination chouetteCombination;
    private final VeluteCombination veluteCombination;

    ChouetteVeluteCombination() {
        chouetteCombination = new ChouetteCombination();
        veluteCombination = new VeluteCombination();
    }

    @Override
    public boolean match(Dices dices) {

        return chouetteCombination.match(dices)
                && veluteCombination.match(dices);
    }

    @Override
    public int compute(Dices dices) {
        return veluteCombination.compute(dices);
    }

    @Override
    public int compute(int value) {
        return veluteCombination.compute(value);
    }
}
