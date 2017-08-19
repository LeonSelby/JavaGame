package com.company.entities.combatunit;

import com.company.Direction;
import com.company.Inventory;
import com.company.entities.combatunit.CombatUnit;
import com.company.items.Item;
import com.company.items.armour.Armour;
import com.company.items.potions.Potion;
import com.company.items.scrolls.*;
import com.company.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player extends CombatUnit {

    private int experiencePoints = 1;
    private Inventory inventory;
    private List<Armour> equipedArmour = new ArrayList<Armour>(4);
    private List<Weapon> equipedWeapon = new LinkedList<Weapon>();

    //Constructor
    public Player(String name) {
        super(name, 1, 1, 1);
    }

    //Methods

    public void move(Direction direction) {

    }

    //May need to make 3 sets more
    public void buy(Item item) {

    }

    public void sell(Item item){}

    public void equip(Armour armour){}

    public void unequip(Armour armour){}

    public void wield(Weapon weapon){

    }

    public void unWield(Weapon weapon){

    }

    public void takePotion(Potion potion){

    }


    //Getters and Setters
    public int getExperiencePoints() {
        return this.experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    //TEST THESE
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

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
