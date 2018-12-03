package com.kaamelott.combination;

import java.util.List;
import java.util.Optional;

public class ChouetteVeluteCombination implements Combination {

    private final VeluteCombination veluteCombination;

    private ChouetteVeluteCombination(VeluteCombination veluteCombination) {
        this.veluteCombination = veluteCombination;
    }

    static ChouetteVeluteCombination from(VeluteCombination veluteCombination) {
        return new ChouetteVeluteCombination(veluteCombination);
    }

    static Optional<ChouetteVeluteCombination> from(List<Integer> orderedDices) {
        Optional<ChouetteCombination> chouetteCombination = ChouetteCombination.from(orderedDices);
        Optional<VeluteCombination> veluteCombination = VeluteCombination.from(orderedDices);

        if (chouetteCombination.isPresent()
                && veluteCombination.isPresent()) {
            return Optional.of(from(veluteCombination.get()));
        }

        return Optional.empty();
    }

    @Override
    public int compute() {
        return veluteCombination.compute();
    }
}
