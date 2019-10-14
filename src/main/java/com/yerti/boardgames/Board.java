package com.yerti.boardgames;

import java.util.ArrayList;
import java.util.List;

public abstract class Board {

    private List<Player> players;

    public Board(int players) {
        this.players = new ArrayList<>();
    }


    public List<Player> getPlayers() {
        return players;
    }

    public abstract void start();

    public abstract void end();
}
