package com.company.entities.combatunit.enemies;

import com.company.entities.combatunit.Enemy;

public class Elf extends Enemy{
    public Elf(String name, int health, int atkRatingBase, int defRatingBase) {
        super(name, 1, atkRatingBase, defRatingBase);
        this.setHealthMax(health);
        this.setHealthCurrent(health);
    }
}
