package com.company;

import com.company.entities.combatunit.Player;

public class Game {

    private Player player1 = new Player("Leon");

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






    //Getters and Setters

    public Player getPlayer1() {
        return this.player1;
    }

}
