package com.company.entities.combatunit;

import com.company.entities.Entity;

public class CombatUnit extends Entity {
    private int level = 1;
    private int AtkRatingBase = 1;
    private int DefRatingBase = 1;
    private int DefRating;
    private int AtkRating;
//    private boolean canCrit = checkIfCanCrit();


    //Constructor

    public CombatUnit(String name, int level, int atkRatingBase, int defRatingBase) {
        super(name);
        this.level = level;
        this.AtkRatingBase = atkRatingBase;
        this.DefRatingBase = defRatingBase;
    }


    //Methods

    public void attack(){

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

    }

    public boolean determineIfCrit(){
        return false;
    }

    public void crit(){

    }

    public void block(){

    }

    public void dodge(){

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









}
