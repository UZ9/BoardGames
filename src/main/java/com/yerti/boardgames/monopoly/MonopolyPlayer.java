package com.yerti.boardgames.monopoly;

import com.yerti.boardgames.Player;
import com.yerti.boardgames.misc.PlayerColor;

public class MonopolyPlayer extends Player {
    private final int STARTING_MONEY = 2000;
    private int money;
    private int currentTile;
    private MonopolyBoard board;


    public MonopolyPlayer(MonopolyBoard board, String name, PlayerColor color) {
        super(name, color);
        this.money = STARTING_MONEY;
        this.currentTile = 0;
        this.board = board;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(int currentTile) {
        this.currentTile = currentTile;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void removeMoney(int amount) {
        money -= amount;
        if (money <= 0) {
            System.out.println(getName() + " has become bankrupt!");
            board.removePlayer(this);
        }
    }
}
