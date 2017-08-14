package com.company.items.armour;

import com.company.items.Item;

public abstract class Armour extends Item {
    private int defRating;


    public Armour(String name, int defRating) {
        super(name);
        this.defRating = defRating;
    }

    public int getDefRating() {
        return this.defRating;
    }

    public void setDefRating(int defRating) {
        this.defRating = defRating;
    }
}
