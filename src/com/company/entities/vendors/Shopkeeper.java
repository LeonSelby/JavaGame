package com.company.entities.vendors;

import com.company.Inventory;

import java.util.InputMismatchException;

public class Shopkeeper {
    private Inventory inventory = new Inventory();


    public Shopkeeper() {
    }

    public void visit(){
        System.out.printf("Need to do Shop Keeper");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
