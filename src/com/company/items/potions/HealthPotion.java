package com.company.items.potions;


public class HealthPotion extends Potion {
    private int recoveryAmount;


    public HealthPotion( int recoveryAmount) {
        super("Health Potion", 20);
        this.recoveryAmount = recoveryAmount;
    }

    public int getRecoveryAmount() {
        return this.recoveryAmount;
    }

    public void setRecoveryAmount(int recoveryAmount) {
        this.recoveryAmount = recoveryAmount;
    }
}
