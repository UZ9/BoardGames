package com.yerti.boardgames.monopoly;

//TODO: Add taxes properties
public class MonopolyTaxes extends MonopolySquare {

    public MonopolyTaxes(String name) {
        super(name);
    }

    @Override
    public void doAction(MonopolyBoard board, MonopolyPlayer player) {
        player.setMoney(player.getMoney() - 200);

        System.out.println("New Balance: " + player.getMoney());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void giveInformation() {
        System.out.println("Type: Taxes");
        //TODO: Change to option between 10% and $200
        System.out.println("Cost: 200");
    }
}
