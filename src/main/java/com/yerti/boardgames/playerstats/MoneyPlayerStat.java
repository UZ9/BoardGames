package com.yerti.boardgames.playerstats;

import com.yerti.boardgames.PlayerStat;

public class MoneyPlayerStat extends PlayerStat {

    int money = 0;

    public MoneyPlayerStat() {
        super("Money");
    }

    @Override
    public Object getStat() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
