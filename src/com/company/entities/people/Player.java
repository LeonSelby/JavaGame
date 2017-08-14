package com.company.entities.people;

import com.company.entities.Person;
import com.company.items.armour.Armour;
import com.company.items.scrolls.*;
import com.company.items.weapons.Weapon;

public class Player extends Person {
    private int level = 1;
    private int AtkRatingBase = 1;
    private int AtkRating;
    private int DefRatingBase = 1;
    private int DefRating;
    private int experiencePoints = 1;
//    private boolean canCrit = checkIfCanCrit();


    //Constructor
    public Player(String name) {
        super(name);
    }


    //Methods

//    public boolean checkIfCanCrit(){
//        boolean ans = false;
//        if(this.getInventory().getListOfScrolls().contains(MasterScroll)){
//            ans = true;
//        }
//        return ans;
//    }







    //Getters and Setters
    public int getExperiencePoints() {
        return this.experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getAtkRating() {
        int rating = getAtkRatingBase();
        for (Weapon w : this.getInventory().getListOfWeapons()) {
            rating += w.getAtkRating();
        }
        return rating;
    }

    public int getDefRating() {
        int rating = getDefRatingBase();
        for (Armour a : this.getInventory().getListOfArmour()) {
            rating += a.getDefRating();
        }
        return rating;
    }

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

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
    }

    public void setAtkRating(int atkRating) {
        this.AtkRating = atkRating;
    }

    public void setDefRating(int defRating) {
        this.DefRating = defRating;
    }
}
