package com.kaamelott;

import com.kaamelott.dice.DiceRoller;
import com.kaamelott.dice.ScannerDiceRoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static DiceRoller diceRoller;

    public static void main(String[] args) {
        initDiceRoller();

        printWelcome();
        List<Player> playerList = getPlayers();

        Players players = Players.of(playerList);
        GameState initialState = GameState.of(players);
        Game game = Game.of(initialState);

        printGameStart();
        game.play();
    }

    private static void initDiceRoller() {
        scanner = new Scanner(System.in);
        diceRoller = ScannerDiceRoller.from(scanner);
//        diceRoller = () -> Dice.from("666");
    }

    private static void printGameStart() {
        System.out.println("Game starts");
    }

    private static void printWelcome() {
        System.out.println("*****************************************");
        System.out.println("* Welcome to the Cul de Chouette game ! *");
        System.out.println("*****************************************");
        System.out.println();
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
        } while (players.size() < 2 || playerName != null && !playerName.isEmpty());

        return players;
    }

    private static void printRulesForPlayerNames() {
        System.out.println("Please type the player names, one by one.");
        System.out.println("The minimum number of players is 2 to play !");
        System.out.println("Type empty name to end asking for next player names.");
    }

    private static void askForNextPlayerName(int nbPlayers) {
        String nThPlayer = getNextPlayerNumber(nbPlayers);
        System.out.println(nThPlayer + " player name : ");
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
