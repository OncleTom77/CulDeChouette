package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;

public class SuiteCombination implements Combination {

    private static final int MALUS_POINT = -10;

    @Override
    public boolean match(Dice dice) {
        return dice.first() == dice.second() - 1
                && dice.second() == dice.third() - 1;
    }

    @Override
    public int compute(Dice dice) {
        return -10; // TODO: change that into action
    }

    @Override
    public Players compute(Dice dice, Players players) {
        Player requestPlayer = players.requestPlayer();
        Player updatedPlayer = requestPlayer.updateScore(MALUS_POINT);

        return players.update(requestPlayer, updatedPlayer);
    }
}
