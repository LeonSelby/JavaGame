package com.company.items;

import com.company.Detailed;

public abstract class Item implements Detailed {

    private String name;

    public Item(String name) {
        this.name = name;
    }


    //Getters and Setters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Detailed
    public String description() {
        return null;
    }

    public void printDescription() {
    }

}
