package com.company;

import com.company.entities.combatunit.Enemy;
import com.company.entities.combatunit.Player;
import com.company.entities.combatunit.enemies.Orc;
import com.company.items.potions.HealthPotion;
import com.company.items.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Battle battle;
    private Player player;
    private Enemy orc;
    private Sword sword;
    private HealthPotion hpPot;


    @Before
    public void setUp(){
        player = new Player("Leon"); //75 HP
        orc = new Orc("Orc", 30, 3, 2);
        sword = new Sword("Sword", 15, 3);
        hpPot = new HealthPotion(40);
        player.getInventory().addWeaponToInventory(sword);
        player.wield(sword);
        battle = new Battle(player);
    }


    @Test
    public void testBattle(){

    }



}
