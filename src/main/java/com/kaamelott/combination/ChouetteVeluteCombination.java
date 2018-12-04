package com.kaamelott.combination;

import java.util.List;

public class ChouetteVeluteCombination implements Combination {

    private final ChouetteCombination chouetteCombination;
    private final VeluteCombination veluteCombination;

    ChouetteVeluteCombination() {
        chouetteCombination = new ChouetteCombination();
        veluteCombination = new VeluteCombination();
    }

    @Override
    public boolean match(List<Integer> orderedDices) {

        return chouetteCombination.match(orderedDices)
                && veluteCombination.match(orderedDices);
    }

    @Override
    public int compute(List<Integer> orderedDices) {
        return veluteCombination.compute(orderedDices);
    }

    @Override
    public int compute(int value) {
        return veluteCombination.compute(value);
    }
}
