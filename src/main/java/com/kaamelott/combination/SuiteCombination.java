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
    public Players compute(Dice dice, Players players) {
        Player requestPlayer = players.requestPlayer("Last player said 'Grelotte ça picotte !' ?");
        Player updatedPlayer = requestPlayer.addScore(MALUS_POINT);

        return players.update(requestPlayer, updatedPlayer);
    }
}
