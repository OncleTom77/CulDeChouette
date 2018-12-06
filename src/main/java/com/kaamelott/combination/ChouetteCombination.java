package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;

class ChouetteCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return dice.second().equals(dice.first())
                ^ dice.second().equals(dice.third());
    }

    @Override
    public int compute(Dice dice) {
        return dice.second() * dice.second();
    }

    @Override
    public Players compute(Dice dice, Players players) {
        final int score = dice.second() * dice.second();
        final Player player = players.currentPlayer();
        final Player updatedPlayer = player.addScore(score);

        return players.update(player, updatedPlayer);
    }
}
