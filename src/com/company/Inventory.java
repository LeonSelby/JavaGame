package com.company;

import com.company.entities.Person;
import com.company.entities.people.Player;
import com.company.items.Item;
import com.company.items.armour.Armour;
import com.company.items.potions.HealthPotion;
import com.company.items.potions.Potion;
import com.company.items.scrolls.Scroll;
import com.company.items.weapons.Weapon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {
    private int capacity = 20;
    private int coinsInBag;

    private List<Armour> listOfArmour = new ArrayList<>(this.getCapacity());
    private List<Weapon> listOfWeapons = new ArrayList<>(this.getCapacity());
    private List<Potion> listOfPotions = new ArrayList<>(this.getCapacity());
    private List<Scroll> listOfScrolls = new ArrayList<>(this.getCapacity());
    private List<List<Item>> inventoryList = new ArrayList<List<Item>>(4) {{
//add(listOfWeapons);
//add(listOfArmour);
//add(listOfPotions);
//add(listOfScrolls);
    }};

    //Create Lists

    public void populateShopKeepersLists(Person shopKeeper) {

    }

    public void populatePlayersInventory(Player player) {
        Potion hpPot = new HealthPotion(10);
        this.listOfPotions.add(hpPot);
        this.addCoins(50);
    } //Players start with 50coins and 1 HP Potion

    //Add and remove
//    public void removeFromInventory(Person person, Item item) {
//        for (List list : inventoryList){
//            for (Item it : list){
//                if(it.equals(item)){
//                    list.remove(item);
//                }
//            }
//        }
//    }


    public boolean checkIfItemIsPresent(Item item) {
        boolean tmp = false;
        if (item instanceof Armour) {
            for (Armour a : this.getListOfArmour()) {
                if (a.equals(item)) {
                    tmp = true;
                }
            }
        } else if (item instanceof Weapon) {
            for (Weapon a : this.getListOfWeapons()) {
                if (a.equals(item)) {
                    tmp = true;
                }
            }
        } else if (item instanceof Potion) {
            for (Potion a : this.getListOfPotions()) {
                if (a.equals(item)) {
                    tmp = true;
                }
            }
        } else if (item instanceof Scroll) {
            for (Scroll a : this.getListOfScrolls()) {
                if (a.equals(item)) {
                    tmp = true;
                }
            }
        }
        return tmp;
    }

    //Remove from Inventory

    public void removeArmourFromInventory(Armour armour) {
        try {
            this.listOfArmour.remove(armour);
        } catch (NullPointerException e) {
            System.out.println("That item isn't present in this inventory.");
        }
    }

    public void removeWeaponFromInventory(Weapon weapon) {
        try {
            this.listOfWeapons.remove(weapon);
        } catch (NullPointerException e) {
            System.out.println("That item isn't present in this inventory.");
        }
    }

    public void removePotionFromInventory(Potion potion) {
        try {
            this.listOfPotions.remove(potion);
        } catch (NullPointerException e) {
            System.out.println("That item isn't present in this inventory.");
        }
    }

    public void removeScrollFromInventory(Scroll scroll) {
        try {
            this.listOfScrolls.remove(scroll);
        } catch (NullPointerException e) {
            System.out.println("That item isn't present in this inventory.");
        }
    }

    //Add to Inventory

    public void addArmourToInventory(Armour item) {
        this.listOfArmour.add(item);
    }

    public void addWeaponToInventory(Weapon item) {
        this.listOfWeapons.add(item);
    }

    public void addPotionToInventory(Potion potion) {
        this.listOfPotions.add(potion);
    }

    public void addScrollToInventory(Scroll scroll) {
        this.listOfScrolls.add(scroll);
    }

    //Getters and Setters Simple

    public List<List<Item>> getInventoryList() {
        return this.inventoryList;
    }

    public void addCoins(int amount) {
        this.coinsInBag = this.getCoinsInBag() - amount;
    }

    public void removeCoins(int amount) {
        int tmp = this.coinsInBag;

        if (amount <= tmp) {
            this.coinsInBag = tmp - amount;
        } else {
            System.out.println("Can't spend that many coins.");
        }
    }   //Fix this, add to Give output

    public List<Armour> getListOfArmour() {
        return this.listOfArmour;
    }

    public List<Weapon> getListOfWeapons() {
        return this.listOfWeapons;
    }

    public List<Potion> getListOfPotions() {
        return this.listOfPotions;
    }

    public List<Scroll> getListOfScrolls() {
        return this.listOfScrolls;
    }

    public int getCoinsInBag() {
        return this.coinsInBag;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
