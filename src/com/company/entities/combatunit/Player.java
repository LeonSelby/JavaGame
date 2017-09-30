package com.company.entities.combatunit;

import com.company.Direction;
import com.company.Inventory;
import com.company.TakeInput;
import com.company.entities.combatunit.CombatUnit;
import com.company.items.Item;
import com.company.items.armour.Armour;
import com.company.items.armour.Helmet;
import com.company.items.potions.HealthPotion;
import com.company.items.potions.Potion;
import com.company.items.scrolls.*;
import com.company.items.weapons.Weapon;
import sun.text.CodePointIterator;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.company.Direction.*;

public class Player extends CombatUnit {

    private int experiencePoints = 1;
    private Inventory inventory = new Inventory();
    private List<Armour> equippedArmour = new ArrayList<Armour>(4);
    private List<Weapon> equippedWeapon = new LinkedList<Weapon>();
    private Point location;
    private Point prevLocation;

    //Constructor
    public Player(String name) {
        super(name, 1, 1, 1);
        this.setHealthMax(75);
        this.setHealthCurrent(75);
        this.location = new Point(10, 1);
        this.prevLocation = new Point(10, 1);
    }

    //Methods

    public Point attemptMove() {
        Direction dir = TakeInput.requestMovementDirection(movementQuestion());
        Point attemptedDest = null;
        if (dir == Dir_NORTH){
            attemptedDest = new Point(this.location.x - 1, this.location.y);
        }else if(dir == Dir_EAST){
            attemptedDest = new Point(this.location.x, this.location.y + 1);
        }else if(dir == Dir_SOUTH){
            attemptedDest = new Point(this.location.x + 1, this.location.y);
        }else if(dir == Dir_WEST){
            attemptedDest = new Point(this.location.x, this.location.y - 1);
        }
        return attemptedDest;
    }

    public void buy(Item item) {
        if (this.getInventory().checkIfCanAfford(item)){
            this.getInventory().addItemToInventory(item);
            this.getInventory().removeCoins(item.getCoinValue());
        }else{
            System.out.println("You don't have enough coins to buy this item!");
        }
    }

    public void sell(Item item){
        if(this.getInventory().checkIfItemIsPresent(item)){
            this.getInventory().removeItemFromInventory(item);
            this.getInventory().addCoins(item.getCoinValue());
        }else{
            System.out.println("You can't sell an item you don't have in your Inventory!");
        }
    }

    public void equip(Armour armour){
        if(!this.getInventory().getListOfArmour().contains(armour)){
            System.out.println("You can't equip armour you don't own!");
        }else {
            if (this.getEquippedArmour().isEmpty()) {
                this.getEquippedArmour().add(armour);
            } else {
                Armour temp = null;
                for (Armour a : this.getEquippedArmour()) {
                    if (a.getClass() == armour.getClass()) {
                        temp = a;
                    }
                }
                this.unequip(temp);
                this.getEquippedArmour().add(armour);
                this.getInventory().getListOfArmour().remove(armour);
            }
        }
    }

    public void unequip(Armour armour){
        if(!this.getEquippedArmour().contains(armour)){
            System.out.println("You can't unequip armour you're not wearing!");
        }else{
            this.getInventory().getListOfArmour().add(armour);
            this.getEquippedArmour().remove(armour);
        }
    }

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

    public void takeHpPotion() {
        if (this.getInventory().getListOfPotions().isEmpty()) {
            System.out.println("You have no potions!");
        } else {
            HealthPotion potion = this.getInventory().getListOfPotions().get(0);
            this.gainHP(potion.getRecoveryAmount());
            this.getInventory().removePotionFromInventory(potion);
        }
    }

public void reportStatistics(){
    System.out.println("Need to add Stats reporting!");
}
    //Getters and Setters
    public int getExperiencePoints() {
        return this.experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    @Override
    public int getAtkRating() {
        int rating = getAtkRatingBase();
        for (Weapon w : this.equippedWeapon) {
            rating += w.getAtkRating();
        }
        return rating;
    }

    @Override
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

    public Point getLocation() {
        return this.location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Point getPrevLocation() {
        return this.prevLocation;
    }

    public void setPrevLocation(Point prevLocation) {
        this.prevLocation = prevLocation;
    }


    public String movementQuestion(){
        return "Which direction would you like to move?";
    }

}
