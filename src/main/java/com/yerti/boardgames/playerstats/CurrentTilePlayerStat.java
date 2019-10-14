package com.yerti.boardgames.playerstats;

import com.yerti.boardgames.PlayerStat;

public class CurrentTilePlayerStat extends PlayerStat {
    private int square;

    public CurrentTilePlayerStat() {
        super("CurrentTile");
    }

    @Override
    public Object getStat() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }
}
