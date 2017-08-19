package com.company.entities;

import com.company.Inventory;

public abstract class Vendor extends Entity {
private Inventory inventory;

    public Vendor(String name) {
        super(name);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
