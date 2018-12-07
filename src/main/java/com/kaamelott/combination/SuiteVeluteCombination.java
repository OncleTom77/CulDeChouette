package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Players;

public class SuiteVeluteCombination implements Combination {

    private final VeluteCombination veluteCombination;
    private final SuiteCombination suiteCombination;

    SuiteVeluteCombination(VeluteCombination veluteCombination, SuiteCombination suiteCombination) {
        this.veluteCombination = veluteCombination;
        this.suiteCombination = suiteCombination;
    }

    @Override
    public boolean match(Dice dice) {
        return dice.first() == 1
                && dice.second() == 2
                && dice.third() == 3;
    }

    @Override
    public Players compute(Dice dice, Players players) {
        Players updatedPlayers = veluteCombination.compute(dice, players);
        return suiteCombination.compute(dice, updatedPlayers);
    }
}
