package com.company;

import com.company.entities.combatunit.Player;

import java.awt.*;

public class Game {

    private GameUtility gameUtils = new GameUtility();
    private Player player1 = new Player("Leon");
    private Board board = new Board(12, player1);
    private Board unalteredBoard = new Board(12, player1);

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

    public void movePlayer(){
        Point startingLoc = player1.getLocation();
        Point targetLoc = player1.attemptMove();
        int targetTile = board.getBoardArray()[targetLoc.x][targetLoc.y];
        if (gameUtils.getListOfUnMoveableTiles().contains(targetTile)){
            System.out.println("Can't move here.");
            if(gameUtils.getListofInteractableTiles().contains(targetTile)){
                System.out.print("But you can interact with this tile, would you like to?");
            }
        } else{
            player1.setLocation(targetLoc);
            player1.setPrevLocation(startingLoc);
        }
        board.updateBoard();
    }


    //Questions

    //Getters and Setters

    public Player getPlayer1() {
        return this.player1;
    }

    public Board getBoard() {
        return this.board;
    }
}
