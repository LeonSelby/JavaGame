package com.company.items.potions;


public class HealthPotion extends Potion {
    private int recoveryAmount;


    public HealthPotion( int recoveryAmount) {
        super("Health Potion");
        this.recoveryAmount = recoveryAmount;
    }
}
