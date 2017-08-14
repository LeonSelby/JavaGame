package com.company.entities;

import com.company.Detailed;

public abstract class Entity implements Detailed {
    private String name;
    private int healthMax;
    private int healthCurrent;
    private boolean isDead = false;


    public String description(){return null;}

    public void printDescription(){}


    //Constructor

    public Entity(String name) {
        this.name = name;
    }

    //Getters and Setters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthMax() {
        return this.healthMax;
    }

    public void setHealthMax(int healthMax) {
        this.healthMax = healthMax;
    }

    public int getHealthCurrent() {
        return this.healthCurrent;
    }

    public void setHealthCurrent(int healthCurrent) {
        this.healthCurrent = healthCurrent;
    }

    public boolean isDead() {
        return this.isDead;
    }

    public void setDead(boolean dead) {
        this.isDead = dead;
    }
}
