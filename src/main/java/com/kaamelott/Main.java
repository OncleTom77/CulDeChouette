package com.kaamelott;

import com.kaamelott.dice.DiceRoller;
import com.kaamelott.dice.ScannerDiceRoller;
import com.kaamelott.game.Game;
import com.kaamelott.game.GameOutput;
import com.kaamelott.game.GameState;
import com.kaamelott.player.Player;
import com.kaamelott.player.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static DiceRoller diceRoller;
    private static GameOutput gameOutput;

    public static void main(String[] args) {
        init();

        printWelcome();
        List<Player> playerList = getPlayers();

        Players players = Players.of(playerList);
        GameState initialState = GameState.of(players);
        Game game = Game.of(initialState, gameOutput);

        printGameStart();
        game.play();
    }

    private static void init() {
        scanner = new Scanner(System.in);
        diceRoller = ScannerDiceRoller.from(scanner);
        gameOutput = System.out::println;
//        diceRoller = () -> Dice.from("666");
    }

    private static void printGameStart() {
        print("Game starts");
    }

    private static void print(String s) {
        gameOutput.print(s);
    }

    private static void printWelcome() {
        print("*****************************************");
        print("* Welcome to the Cul de Chouette game ! *");
        print("*****************************************");
        print("");
    }

    private static List<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        String playerName;

        printRulesForPlayerNames();

        do {
            askForNextPlayerName(players.size());
            playerName = scanner.nextLine();

            if (playerName != null
                    && !playerName.isEmpty()) {
                players.add(Player.of(playerName, diceRoller));
            }
        } while (players.size() < 2
                || playerName != null
                && !playerName.isEmpty());

        return players;
    }

    private static void printRulesForPlayerNames() {
        print("Please type the player names, one by one.");
        print("The minimum number of players is 2 to play !");
        print("Type empty name to end asking for next player names.");
    }

    private static void askForNextPlayerName(int nbPlayers) {
        String nThPlayer = getNextPlayerNumber(nbPlayers);
        print(nThPlayer + " player name : ");
    }

    private static String getNextPlayerNumber(int nbPlayers) {
        String nThPlayer;
        switch (nbPlayers) {
            case 0:
                nThPlayer = "1st";
                break;
            case 1:
                nThPlayer = "2nd";
                break;
            case 2:
                nThPlayer = "3rd";
                break;
            default:
                nThPlayer = (nbPlayers + 1) + "th";
        }
        return nThPlayer;
    }
}
