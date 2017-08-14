package com.company.items.armour;

public class Helmet extends Armour {

    private int trapProtection;
    private boolean negatesTraps = checkIfTrapsNegated();



    public Helmet(String name, int defRating, int trapProtection) {
        super(name, defRating);
        this.trapProtection = trapProtection;
    }

    //Methods

    public boolean checkIfTrapsNegated(){
        boolean ans = false;
        int percent = this.trapProtection;
        if(percent==100){
            ans = true;
        }
        return ans;
    }

    //Getters and Setters

    public int getTrapProtection() {
        return trapProtection;
    }

    public void setTrapProtection(int trapProtection) {
        this.trapProtection = trapProtection;
    }

    public boolean isNegatesTraps() {
        return negatesTraps;
    }

    public void setNegatesTraps(boolean negatesTraps) {
        this.negatesTraps = negatesTraps;
    }
}
