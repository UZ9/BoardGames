package com.yerti.boardgames.monopoly;

public class MonopolyChance extends MonopolySquare {


    public MonopolyChance(String name) {
        super(name);
    }

    @Override
    public void doAction(MonopolyBoard board, MonopolyPlayer player) {
        int selectedChanceCard = (int) (Math.random() * (17 + 1));

        switch (selectedChanceCard) {
            case 0:
                System.out.println("Advance to \"Go\". Collect $200");
                player.setCurrentTile(0);
                player.addMoney(200);

                //player.setMoney(player.getMoney() + 200);
                break;
            case 1:
                System.out.println("Bank pays you dividend of $50.");
                player.addMoney(50);
                //player.setMoney(player.getMoney() + 50);
                break;
            case 2:
                System.out.println("Go back three spaces.");
                for (int i = 0; i < 3; i++) {
                    player.setCurrentTile(player.getCurrentTile() - 1);
                    if (player.getCurrentTile() < 0) {
                        player.setCurrentTile(MonopolyProperty.getSquares().length - 1);
                    }
                }
                break;
            case 3:
                System.out.println("Pay each player $50");
                for (MonopolyPlayer otherPlayer : board.getMonopolyPlayers()) {
                    if (otherPlayer.equals(player)) continue;
                    player.removeMoney(50);
                    //player.setMoney(player.getMoney() - 50);
                    otherPlayer.addMoney(50);
                    //otherPlayer.setMoney(player.getMoney() + 50);
                }
                break;
            case 4:
                System.out.println("Your building loan matures. Recieve $150");
                player.addMoney(150);
                //player.setMoney(player.getMoney() + 150);
                break;
            case 5:
                System.out.println("Pay a poor tax of $15");
                player.removeMoney(15);
                //player.setMoney(player.getMoney() - 15);
                break;
            case 6:
                System.out.println("You have won a crossword competition. Collect $100.");
                player.addMoney(100);
                //player.setMoney(player.getMoney() + 100);
                break;

        }

        System.out.println("New Balance: " + player.getMoney());
    }

    @Override
    public void giveInformation() {
        System.out.println("Type: Chance");
    }
}
