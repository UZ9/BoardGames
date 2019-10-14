package com.yerti.boardgames.monopoly;

import com.yerti.boardgames.Board;
import com.yerti.boardgames.Player;
import com.yerti.boardgames.misc.Die;
import com.yerti.boardgames.misc.PlayerColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonopolyBoard extends Board {

    private MonopolySquare[] monopolySquares;
    private List<MonopolyPlayer> players;
    private boolean gameRunning = false;
    private int currentTurn = 0;

    public MonopolyBoard(int players, int startingMoney) {
        super(players);

        this.monopolySquares = MonopolySquare.getSquares();
        this.players = new ArrayList<>();

        this.die = new Die();
        for (int i = 0; i < players; i++) {
            this.players.add(new MonopolyPlayer(this,"Bob" + i, PlayerColor.BLUE));
        }
    }

    private final Die die;

    @Override
    public void start() {

        gameRunning = true;

        currentTurn = (int) (Math.random() * (getPlayers().size() + 1));





        while (gameRunning) {

            System.out.println("Player " + players.get(currentTurn).getName() + ", you're up!\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(players.get(currentTurn).getName() + " currently has: $" + players.get(currentTurn).getMoney());

            MonopolyPlayer monopolyPlayer = players.get(currentTurn);

            int roll = die.rollDice(2, 6);
            MonopolySquare outputSquare = moveSquare(monopolyPlayer, roll);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------------------------------");
            System.out.println(monopolyPlayer.getName() + " rolled a " + roll + " and landed on " + outputSquare.getName());
            System.out.println("------------------------------------");
            System.out.println("          Square Information         ");
            outputSquare.giveInformation();
            System.out.println("------------------------------------");
            outputSquare.doAction(this, monopolyPlayer);

            nextTurn();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    public void end() {
        gameRunning = false;
    }

    private void nextTurn() {
        if (currentTurn++ >= players.size() - 1) {
            currentTurn = 0;
        }
    }


    //TODO: Fix
    public List<MonopolyPlayer> getMonopolyPlayers() {
        return players;
    }

    private MonopolySquare moveSquare(MonopolyPlayer player, int endingPosition) {
        for (int i = 0; i < endingPosition; i++) {
            player.setCurrentTile(player.getCurrentTile() + 1);
            if (player.getCurrentTile() >= monopolySquares.length) {
                player.setCurrentTile(0);
            }
        }

        return monopolySquares[player.getCurrentTile()];
    }

    public void removePlayer(MonopolyPlayer player) {
        players.remove(player);
    }
}
