package com.yerti.boardgames.misc;

public class Die {

    public Die() {

    }

    public int rollDice(int diceAmount, int sides) {
        int output = 0;
        for (int i = 0; i < diceAmount; i++) {
            output += (int) (Math.random() * (sides - 1)) + 1;
        }
        return output;
    }

}
