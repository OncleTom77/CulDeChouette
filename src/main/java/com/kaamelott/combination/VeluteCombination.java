package com.kaamelott.combination;

import com.kaamelott.dice.Dice;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;

public class VeluteCombination implements Combination {

    @Override
    public boolean match(Dice dice) {
        return dice.first() + dice.second() == dice.third();
    }

    @Override
    public int compute(Dice dice) {
        return dice.third() * dice.third() * 2;
    }

    @Override
    public Players compute(Dice dice, Players players) {
        Player affectedPlayer = players.currentPlayer();

        return updateScoreOfAffectedPlayerInPlayers(dice, players, affectedPlayer);
    }

    Players updateScoreOfAffectedPlayerInPlayers(Dice dice, Players players, Player affectedPlayer) {
        int score = dice.third() * dice.third() * 2;
        final Player updatedPlayer = affectedPlayer.addScore(score);

        return players.update(affectedPlayer, updatedPlayer);
    }
}
