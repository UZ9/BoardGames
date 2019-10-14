package com.yerti.boardgames.monopoly;

import com.yerti.boardgames.Player;

import java.util.Scanner;

public class MonopolyProperty extends MonopolySquare {

    private MonopolyPlayer playerOwner = null;
    private int price;


    public MonopolyProperty(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public void doAction(MonopolyBoard board, MonopolyPlayer monopolyPlayer) {

        if (playerOwner == null) {
            System.out.println("Do you want to buy this property? [Y] [N]");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine();

            boolean foundResponse = false;

            do {
                if (response.toLowerCase().equals("y")) {
                    if (getPrice() > monopolyPlayer.getMoney()) {
                        System.out.println("That's too expensive for you!");
                    } else {
                        monopolyPlayer.setMoney(monopolyPlayer.getMoney() - getPrice());
                        System.out.println("Purchased " + getName() + ". New balance: $" + monopolyPlayer.getMoney());
                        this.playerOwner = monopolyPlayer;

                    }

                    foundResponse = true;

                } else if (response.toLowerCase().equals("n")) {
                    System.out.println("Not buying property");
                    foundResponse = true;
                } else {
                    System.out.println("Please enter a valid response!");

                    response = scanner.next();
                    //response = scanner.nextLine();
                }

            } while (!foundResponse);
        } else {

            int priceToPay = getPrice() * 4/10;

            System.out.println(monopolyPlayer.getName() + " has to pay $" + priceToPay + " to " + playerOwner.getName());
            System.out.println("------------------------------------");

            monopolyPlayer.setMoney(monopolyPlayer.getMoney() - priceToPay);
            playerOwner.setMoney(playerOwner.getMoney() + priceToPay);

            System.out.println(monopolyPlayer.getName() + "'s new balance: $" + monopolyPlayer.getMoney());
            System.out.println(playerOwner.getName() + "'s new balance: $" + playerOwner.getMoney());
            System.out.println("------------------------------------");


        }
    }

    @Override
    public void giveInformation() {
        System.out.println("Type: Property");
        System.out.println("Price: " + getPrice());
        System.out.println("Owner: " + (playerOwner == null ? "N/A" : playerOwner.getName()));
    }

    public int getPrice() {
        return price;
    }




}
