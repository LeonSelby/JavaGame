package com.company.entities.combatunit;

public abstract class Enemy extends CombatUnit {
    public Enemy(String name, int level, int atkRatingBase, int defRatingBase) {
        super(name, level, atkRatingBase, defRatingBase);
    }
}
