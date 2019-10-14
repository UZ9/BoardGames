package com.yerti.boardgames;

public abstract class PlayerStat {

    public String name;

    public PlayerStat(String name) {
        this.name = name;
    }

    public abstract Object getStat();
}
