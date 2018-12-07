package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;

public class ChouetteVeluteCombination extends VeluteCombination {

    private final ChouetteCombination chouetteCombination;

    ChouetteVeluteCombination() {
        chouetteCombination = new ChouetteCombination();
    }

    @Override
    public boolean match(Dice dice) {
        return super.match(dice)
                && chouetteCombination.match(dice);
    }

    @Override
    public Players compute(Dice dice, Players players) {
        Player affectedPlayer = players.requestPlayer();
        return updateScoreOfAffectedPlayerInPlayers(dice, players, affectedPlayer);
    }
}
