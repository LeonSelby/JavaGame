package com.company.items.weapons;

import com.company.items.Item;

public abstract class Weapon extends Item {
    private int AtkRating;

    public Weapon(String name, int atkRating) {
        super(name);
        AtkRating = atkRating;
    }

    public int getAtkRating() {
        return this.AtkRating;
    }

    public void setAtkRating(int atkRating) {
        this.AtkRating = atkRating;
    }
}
