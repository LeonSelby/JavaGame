package com.company;

import com.company.entities.combatunit.CombatUnit;
import com.company.entities.combatunit.Enemy;
import com.company.entities.combatunit.Player;
import com.company.entities.combatunit.enemies.Elf;
import com.company.entities.combatunit.enemies.Goblin;
import com.company.entities.combatunit.enemies.Orc;
import com.company.entities.combatunit.enemies.Undead;
import com.company.items.Item;
import com.company.items.armour.Boots;
import com.company.items.armour.Breastplate;
import com.company.items.armour.Helmet;
import com.company.items.armour.Leggings;
import com.company.items.potions.HealthPotion;
import com.company.items.weapons.Sword;

import java.util.Random;

public class Battle {
    private Player player;
    private Enemy enemy;

    //Constructor
    public Battle(Player player1) {
        this.player = player1;
        this.enemy = determineEnemy();
        this.player.setInCombat(true);
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
        Enemy enemy = null;
        Random random = new Random();
        int a = random.nextInt(5) + 1;
        int level = player.getLevel();
        switch (level){
            case 1:
                enemy = new Undead("Zombie", random.nextInt(20)+16,
                        3, 1);
                break;
            case 2:
                if(a<3){
                    enemy = new Undead("Zombie", random.nextInt(20)+16,
                            3, 1);
                }else{
                    enemy = new Goblin("Gobbo", random.nextInt(25)+17,
                            2, 2);
                }
                break;
            case 3:
                if(a<2){
                    enemy = new Undead("Zombie", random.nextInt(20)+16,
                            3, 1);
                }else if(a<4){
                    enemy = new Goblin("Big Gobbo", random.nextInt(45)+35,
                            4, 3);
                }else{
                    enemy = new Elf("Blood Elf", random.nextInt(60)+55,
                            7, 5);
                }
                break;
            case 4:
                if(a<2){
                    enemy = new Goblin("Big Gobbo", random.nextInt(45)+35,
                            4, 3);
                }else if(a<3){
                    enemy = new Elf("Blood Elf", random.nextInt(60)+55,
                            7, 5);
                }else{
                    enemy = new Orc("HellScream", random.nextInt(100)+99,
                            10, 7);
                }
                break;
            case 5:
                if(a<2){
                    enemy = new Goblin("Big Gobbo", random.nextInt(45)+35,
                            4, 3);
                }else if(a<3){
                    enemy = new Elf("Blood Elf", random.nextInt(60)+55,
                            7, 5);
                }else if(a<5){
                    enemy = new Orc("HellScream", random.nextInt(100)+99,
                            10, 7);
                }else {
                    enemy = new Orc("Thrall", random.nextInt(150)+100,
                            11, 9);
                }
                break;
        }
        return enemy;
    }

    public void reduceHpOf(CombatUnit combatUnit, int hpToLose) {
        combatUnit.loseHP(hpToLose);
    }

    public void turn(CombatUnit combatUnit) {
        int ans = offerOptions();
        switch (ans){
            case 1:
                player.attack(this.getEnemy());
                break;
            case 2:
                player.takeHpPotion();
                break;
            case 3:
                player.flee();
                break;
        }
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

    public void awardLoot(Player player){
        Random random = new Random();
        int o = random.nextInt(3) + 1;
        if(o>1){
            Item loot = determineLoot();
            player.getInventory().addItemToInventory(loot);
        }else{
            int coinsReward = random.nextInt(30) + 20;
            HealthPotion potion = new HealthPotion(50);
            player.getInventory().addItemToInventory(potion);
            player.getInventory().addCoins(coinsReward);
        }
    }

    public int determineEXP(){
        int exp;
        int enemyHealthMax = enemy.getHealthMax();
        if(enemyHealthMax < 20){
            exp = 10;
        }else if(enemyHealthMax < 30){
            exp = 15;
        }else if(enemyHealthMax < 60){
            exp = 20;
        }else if(enemyHealthMax < 80){
            exp = 25;
        }else if(enemyHealthMax < 100){
            exp = 30;
        }else{
            exp = 50;
        }
        return exp;
    }

    public void awardEXP(){
        int exp = determineEXP();
        player.setExperiencePoints(player.getExperiencePoints()+ exp);
    }

    public void endGame(){

    }

    public int offerOptions(){
        return TakeInput.requestInputInRange(this.optionsString(), 1, 3);
    }



    //Getters and Setters
    public Enemy getEnemy() {
        return this.enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
