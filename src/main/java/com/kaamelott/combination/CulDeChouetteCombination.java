package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;

public class CulDeChouetteCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return dice.first().equals(dice.second())
                && dice.first().equals(dice.third());
    }

    @Override
    public int compute(Dice dice) {
        return 40 + dice.first() * 10;
    }

    @Override
    public Players compute(Dice dice, Players players) {
        int score = 40 + dice.first() * 10;
        Player affectedPlayer = players.currentPlayer();
        final Player updatedPlayer = affectedPlayer.addScore(score);

        return players.update(affectedPlayer, updatedPlayer);
    }
}
