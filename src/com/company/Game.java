package com.company;

import com.company.entities.combatunit.Player;
import com.company.entities.vendors.Shopkeeper;
import com.company.items.Item;
import com.company.items.armour.*;
import com.company.items.weapons.Sword;
import com.company.items.weapons.Weapon;

import java.awt.*;
import java.util.Random;

public class Game {

    private GameUtility gameUtils = new GameUtility();
    private Player player1 = new Player("Leon");
    private Board board = new Board(12, player1);
    private Board unalteredBoard = new Board(12, player1);
    private Shopkeeper shop = new Shopkeeper();

    public void randomBattle(){
        Battle battle = new Battle(player1);
        System.out.println(battle.introString());

        while(!player1.isDead() && !battle.getEnemy().isDead() && player1.isInCombat()) {
            System.out.println(battle.hpDeclarations());
            battle.turn(player1);
            System.out.println(battle.hpDeclarations());
            if (!battle.getEnemy().isDead()) {
                battle.turn(battle.getEnemy());
            }
        }
        try {
            System.out.println(battle.winnerString(battle.determineWinner()));
        }catch (NullPointerException npe){
            System.out.println(battle.fleeSuccess());
        }
        battle.awardEXP();
        battle.awardLoot();
    }

    public void bossBattle(){
        System.out.println("Need to do Boss Battle!");
    }

    public void movePlayer(){
        Point startingLoc = player1.getLocation();
        Point targetLoc = player1.attemptMove();
        int targetTile = board.getBoardArray()[targetLoc.x][targetLoc.y];
        String tile = determineTargetTile(targetTile);
        if (gameUtils.getListOfUnMoveableTiles().contains(targetTile)){
            System.out.println("Can't move here.");
            if(gameUtils.getListofInteractableTiles().contains(targetTile)){
                boolean ans = TakeInput.requestYesOrNo
                        ("But you can interact with " + tile + ", would you like to?");
                if(ans){
                    if(targetTile == 1){
                        Item item = determineLoot();
                        player1.getInventory().addItemToInventory(item);
                        System.out.println(item.getName() + " has been added to bag!");
                        board.getBoardArray()[targetLoc.x][targetLoc.y] = 9; // UNDO COMMENT TO GIVE LOOT FOREVER
                        board.getPureBoard()[targetLoc.x][targetLoc.y] = 9; // UNDO COMMENT TO GIVE LOOT FOREVER
                    }else if(targetTile == 2){
                        shop.visit();
                    }else if(targetTile == 5){
                        bossBattle();
                    }else if(targetTile == 6) {
                        System.out.println("Buffs not yet added!");
                    }else if(targetTile == 9){
                        System.out.println("That chest has already been opened!");
                    }else if(targetTile == 10){
                        Sword superSword = new Sword("Super Sword", 1000, 60);
                        player1.getInventory().addWeaponToInventory(superSword);
                        System.out.println(superSword.getName()+ " has been added to bag!");
                        board.getBoardArray()[targetLoc.x][targetLoc.y] = 9; // UNDO COMMENT TO GIVE LOOT FOREVER
                        board.getPureBoard()[targetLoc.x][targetLoc.y] = 9; // UNDO COMMENT TO GIVE LOOT FOREVER
                    }
                }
            }else {
                System.out.print("A " + tile + " blocks your way!");
            }
        } else{
            player1.setLocation(targetLoc);
            player1.setPrevLocation(startingLoc);
        }
        board.updateBoard();
    }

public void takeTurn(){
        int ans = TakeInput.requestInputInRange(presentOption(), 1, 10);
    if(ans == 1){
        movePlayer();
    }else if(ans == 2){
        board.printBoard();
    }else if(ans == 3){
        for (Weapon w: player1.getEquippedWeapon()) {
            System.out.println(w.getName() + " has an attack rating of " + w.getAtkRating());
        }
        for (Armour a: player1.getEquippedArmour()) {
            System.out.println(a.getName() + " has a defense rating of " + a.getDefRating());
        }
    }else if(ans == 4){
        player1.getInventory().open();
    }else if(ans == 5){
        player1.takeHpPotion();
    }else if(ans == 6){
        player1.reportStatistics();
    }
}

    private String determineTargetTile(int targetTile){
        String tile = "";
        if(targetTile == 1) {
            tile = "Chest";
        }else if(targetTile == -1){
            tile = "Barrier";
        }else if(targetTile == 2){
            tile = "Shop";
        }else if(targetTile == 5){
            tile = "Boss";
        }else if(targetTile == 6){
            tile = "Obelisk";
        }else if(targetTile == 10){
            tile = "Large Chest";
        }
        return tile;
    }


    public Item determineLoot(){
        Item temp = null;
        Random random = new Random();
        int n = random.nextInt(10) + 1;
        int m = random.nextInt(5) + 1;

        if (n < 6) {
            switch (m) {
                case 1:
                    temp = new Helmet("Cloth Helmet", 15, 1, 10);
                    break;
                case 2:
                    temp = new Breastplate("Cloth Shirt", 15, 1);
                    break;
                case 3:
                    temp = new Leggings("Cloth Trousers", 15, 1);
                    break;
                case 4:
                    temp = new Boots("Cloth Boots", 15, 1, 10);
                    break;
                case 5:
                    temp = new Sword("Wooden Sword", 20, 3);
                    break;
            }
        } else if (n < 10 && n > 5) {
            switch (m) {
                case 1:
                    temp = new Helmet("Leather Helmet", 30, 3, 50);
                    break;
                case 2:
                    temp = new Breastplate("Leather Shirt", 30, 3);
                    break;
                case 3:
                    temp = new Leggings("Leather Trousers", 30, 3);
                    break;
                case 4:
                    temp = new Boots("Leather Boots", 30, 3, 50);
                    break;
                case 5:
                    temp = new Sword("Valyrian Sword", 75, 12);
                    break;
            }
        } else if (n < 11 && n > 9) {
            switch (m) {
                case 1:
                    temp = new Helmet("Plate Helmet", 60, 7, 100);
                    break;
                case 2:
                    temp = new Breastplate("Plate Shirt", 60, 7);
                    break;
                case 3:
                    temp = new Leggings("Plate Trousers", 60, 7);
                    break;
                case 4:
                    temp = new Boots("Plate Boots", 60, 7, 100);
                    break;
                case 5:
                    temp = new Sword("Master Sword", 200, 30);
                    break;
            }
        }
        return temp;
    }
    //Questions

    private String presentOption(){
        return "What would you like to do?" + "\n 1. Move. \n 2. See Map.\n" +
                " 3. See Equipped Items. \4. See Inventory. \n 5. Take Potion. \n 6. See statistics.";
    }
    //Getters and Setters

    public Player getPlayer1() {
        return this.player1;
    }

    public Board getBoard() {
        return this.board;
    }
}
