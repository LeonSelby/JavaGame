package com.company.entities.combatunit;

import com.company.Direction;
import com.company.Inventory;
import com.company.entities.combatunit.CombatUnit;
import com.company.items.Item;
import com.company.items.armour.Armour;
import com.company.items.potions.HealthPotion;
import com.company.items.potions.Potion;
import com.company.items.scrolls.*;
import com.company.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player extends CombatUnit {

    private int experiencePoints = 1;
    private Inventory inventory = new Inventory();
    private List<Armour> equippedArmour = new ArrayList<Armour>(4);
    private List<Weapon> equippedWeapon = new LinkedList<Weapon>();

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
        if(!this.getInventory().getListOfWeapons().contains(weapon)){
            System.out.println("You can't equip a weapon you don't own!");
        }else{
            Weapon temp;
            if(this.getEquippedWeapon().isEmpty()){
                this.getEquippedWeapon().add(weapon);
            }else {
                temp = this.getEquippedWeapon().get(0);
                this.unWield(temp);
                this.getEquippedWeapon().add(weapon);
                this.getInventory().getListOfWeapons().remove(weapon);
            }
        }
    }

    public void unWield(Weapon weapon){
        if(!this.getEquippedWeapon().contains(weapon)){
            System.out.println("You can't unwield a weapon you're not holding!");
        }else{
            this.getInventory().getListOfWeapons().add(weapon);
            this.getEquippedWeapon().remove(weapon);
        }
    }

    public void takeHpPotion(HealthPotion potion) {
        if (!this.getInventory().getListOfPotions().contains(potion)) {
            System.out.println("You have no potions!");
        } else {
            this.gainHP(potion.getRecoveryAmount());
            this.getInventory().removePotionFromInventory(potion);
        }
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
        for (Weapon w : this.equippedWeapon) {
            rating += w.getAtkRating();
        }
        return rating;
    }

    public int getDefRating() {
        int rating = getDefRatingBase();
        for (Armour a : this.equippedArmour) {
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

    public List<Armour> getEquippedArmour() {
        return this.equippedArmour;
    }

    public void setEquippedArmour(List<Armour> equipedArmour) {
        this.equippedArmour = equipedArmour;
    }

    public List<Weapon> getEquippedWeapon() {
        return this.equippedWeapon;
    }

    public void setEquippedWeapon(List<Weapon> equipedWeapon) {
        this.equippedWeapon = equipedWeapon;
    }
}
