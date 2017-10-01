package com.company.entities.combatunit;

import com.company.entities.Entity;

import java.util.Random;

public class CombatUnit extends Entity {
    private int level = 1;
    private int AtkRatingBase = 1;
    private int DefRatingBase = 1;
    private int defRating;
    private int atkRating;
    private boolean inCombat = false;
//    private boolean canCrit = checkIfCanCrit();


    //Constructor

    public CombatUnit(String name, int level, int atkRatingBase, int defRatingBase) {
        super(name);
        this.level = level;
        this.AtkRatingBase = atkRatingBase;
        this.DefRatingBase = defRatingBase;

    }

    //Methods

    public String declareDMG(int dmg, CombatUnit target){
        return target.getName() + " has taken " + dmg + " damage!";
    }

    public void attack(CombatUnit target){
        int attackersAtkRating = this.getAtkRating();
        int defendersDefRating = target.getDefRating();
        if(this.determineIfCrit()){
            System.out.println("CRIT!");
            attackersAtkRating += attackersAtkRating;
        }else if(target.dodge()){
            System.out.println("DODGED!");
            attackersAtkRating = 0;
        }else if(this.block()){
            System.out.println("BLOCKED!");
            defendersDefRating = defendersDefRating + (defendersDefRating/2);
        }
        int damage = attackersAtkRating - defendersDefRating;
        target.loseHP(damage);
        System.out.println(declareDMG(damage, target));
    }

    public void loseHP(int hpToLose){
        if(hpToLose < 0){
            hpToLose = 0;
        }//Prevents gaining health on loseHP Method.

        if (hpToLose >= this.getHealthCurrent()){
            this.setHealthCurrent(0);
            this.setDead(true);
        }else if(hpToLose < this.getHealthCurrent()){
            this.setHealthCurrent(this.getHealthCurrent()-hpToLose);
        }
    }

    public void gainHP(int hpToGain){
        int missingHp = this.getHealthMax() - this.getHealthCurrent();

        if(hpToGain < 0){
            hpToGain = 0;
        }//Prevents losing health on gainHP Method.

        if (hpToGain >= missingHp){
            this.setHealthCurrent(this.getHealthMax());
        }else if(hpToGain <= missingHp){
            this.setHealthCurrent(this.getHealthCurrent()+ hpToGain);
        }
    }

    public void die(){

    }

    public void flee(){
        Random random = new Random();
        int n = random.nextInt(20) + 1;
        if(n != 20) {
            this.setInCombat(false);
        }else{
            System.out.println("Flee failed!");
        }
    }

    public boolean determineIfCrit(){
        Random random = new Random();
        int n = random.nextInt(20) + 1;
        return n == 20;
    }


    public boolean block(){
        Random random = new Random();
        int n = random.nextInt(20) + 1;
        return n > 17;
    }

    public boolean dodge(){
        Random random = new Random();
        int n = random.nextInt(20) + 1;
        return n == 20;
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
    }


    //Getters and Setters
    public int getAtkRatingBase() {
        return this.AtkRatingBase;
    }

    public void setAtkRatingBase(int atkRatingBase) {
        this.AtkRatingBase = atkRatingBase;
    }

    public int getDefRatingBase() {
        return this.DefRatingBase;
    }

    public void setDefRatingBase(int defRatingBase) {
        this.DefRatingBase = defRatingBase;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDefRating() {
        return this.getDefRatingBase()+this.defRating;
    }

    public void setDefRating(int defRating) {
        this.defRating = defRating;
    }

    public int getAtkRating() {
        return this.getAtkRatingBase()+this.atkRating;
    }

    public void setAtkRating(int atkRating) {
        this.atkRating = atkRating;
    }

    public boolean isInCombat() {
        return this.inCombat;
    }

    public void setInCombat(boolean inCombat) {
        this.inCombat = inCombat;
    }
}
