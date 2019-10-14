package com.yerti.boardgames.monopoly;

import com.yerti.boardgames.Player;

public abstract class MonopolySquare {

    private String name;
    private boolean owned;

    public MonopolySquare(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static final MonopolySquare[] getSquares() {
        MonopolySquare[] squares = new MonopolySquare[] {
                new MonopolyProperty("Baltic Ave.", 60),
                new MonopolyProperty("Mediterranean Ave.", 60),
                new MonopolyProperty("St. Charles Place", 140),
                new MonopolyProperty("Ventnor Ave.", 260),
                new MonopolyProperty("Vermont Ave.", 100),
                new MonopolyProperty("States Ave.", 140),
                new MonopolyProperty("Virginia Ave.", 160),
                new MonopolyTaxes("Taxes 1"),
                new MonopolyProperty("Kentucky Ave.", 220),
                new MonopolyProperty("Marvin Gardens", 300),
                new MonopolyProperty("Atlantic Ave.", 260),
                new MonopolyProperty("North Carolina Ave.", 320),
                new MonopolyProperty("Pacific Ave", 300),
                new MonopolyChance("Chance1"),
                new MonopolyProperty("Pennsylvania Ave.", 35),
                new MonopolyProperty("Park Place", 350),
                new MonopolyProperty("Boardwalk", 400)

        };

        return squares;




    }

    public abstract void doAction(MonopolyBoard board,  MonopolyPlayer player);

    public abstract void giveInformation();
}
