package com.company;

import com.company.entities.Entity;
import com.company.entities.combatunit.CombatUnit;
import com.company.entities.combatunit.Enemy;
import com.company.entities.combatunit.Player;
import com.company.items.Item;

public class Battle {
    private Player player;
    private Enemy enemy;

    //Constructor
    public Battle(Player player1) {
        this.player = player1;
        this.enemy = determineEnemy();
    }

    //Strings

    public String declareEnemy() {
        return this.getEnemy().toString();
    }

    public String introString() {
        return null;
    }

    public String winnerString() {
        return null;
    }

    public String expString() {
        return null;
    }

    public String leveledUpString() {
        return null;
    }

    public String declareHPLoss(CombatUnit combatUnit, int hpToLose) {
        return combatUnit.getName() + " has lost " + hpToLose + " HP!";
    }

    public String declareLoot(Item loot){
        return loot.getName()+" has dropped!";
    }

    public String optionsString(){
        return "Please select your next action:\n1. Attack\n2. Take Potion\n3. Flee";
    }


    //Methods

    public Enemy determineEnemy() {
        return null;
    }

    public void reduceHpOf(CombatUnit combatUnit, int hpToLose) {
        combatUnit.loseHP(hpToLose);
    }

    public void turn(CombatUnit combatUnit) {

    }

    public Item determineLoot(){
        return null;
    }

    public void awardLoot(Item loot){

    }

    public void endGame(){

    }

    public void offerOptions(){

    }



    //Getters and Setters
    public Enemy getEnemy() {
        return this.enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
