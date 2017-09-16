package com.company;

import com.company.entities.combatunit.Player;
import com.company.entities.combatunit.enemies.*;
import com.company.items.potions.HealthPotion;
import com.company.items.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

public class BattleTest {

    Battle battle;
    Player player;
    Orc orc;
    Goblin goblin;
    Elf elf;
    Undead undead;
    Sword sword;
    HealthPotion hpPot;


    @Before
    public void before(){
        player = new Player("Leon");
        battle = new Battle(player);
        orc = new Orc("Orc", 60, 3, 3);
        goblin = new Goblin("Goblin", 30, 1, 2);
        elf = new Elf("Elf", 40, 4, 2);
        undead = new Undead("Elf", 40, 4, 2);
        sword = new Sword("sword", 20, 5);
        hpPot = new HealthPotion(50);
        player.getInventory().addWeaponToInventory(sword);
        player.wield(sword);
        player.getInventory().addPotionToInventory(hpPot);
    }

    @Test
    public void turn_Test(){
        battle.setEnemy(orc);
        player.setHealthCurrent(10);
        battle.turn(player);
    }

    @Test
    public void determineLoot_Test(){
        System.out.println(battle.determineLoot().getName());
    }

    @Test
    public void awardLoot_Test(){
        System.out.println(player.getInventory().getCoinsInBag());
        battle.awardLoot();
        System.out.println(player.getInventory().getCoinsInBag());
    }

    @Test
    public void determineEnemy_Test(){
        player.setLevel(5);
        System.out.println(battle.determineEnemy().getName());
    }

}
