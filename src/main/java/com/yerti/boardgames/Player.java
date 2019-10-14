package com.yerti.boardgames;

import com.yerti.boardgames.misc.PlayerColor;

import java.util.List;

public class Player {

    private final PlayerColor color;
    private final String name;

    public Player(String name, PlayerColor color) {
        this.color = color;
        this.name = name;
    }

    public PlayerColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
