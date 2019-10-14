package com.yerti.boardgames;

import com.yerti.boardgames.monopoly.MonopolyBoard;
import com.yerti.boardgames.playerstats.CurrentTilePlayerStat;
import com.yerti.boardgames.playerstats.MoneyPlayerStat;

import java.util.Collections;
import java.util.Scanner;

public class GameInitializer {

    private Board board;

    public GameInitializer() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the BoardGames program! How many players will be in your match?");

        int playerCount = 0;

        do {

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid player number.");
                scanner.next();
            }
            playerCount = scanner.nextInt();
        } while (playerCount <= 0);

        System.out.println("What game type do you want?");
        System.out.println("Current options: MONOPOLY");
        String input = "";
        do {
            String tempInput = scanner.next();
            if (tempInput.equalsIgnoreCase("MONOPOLY")) {
                input = "MONOPOLY";
            } else {
                System.out.println("Please enter a valid game!");
                scanner.next();
            }
        }  while (input.equals(""));

        System.out.println("\nGame Information:");
        System.out.println("Players: " + playerCount);
        System.out.println("Game Type: " + input);
        System.out.println(" ");
        Thread.sleep(1000);

        System.out.println("Starting match with " + playerCount + " people.");

        //TODO: Find some way of starting the board from Class.forName (or another method) instead of manually doing new MonopolyBoard
        //board = Class.forName(input + "Board").asSubclass(Board.class);
        board = new MonopolyBoard(playerCount, 5000);
        board.start();

    }

}
