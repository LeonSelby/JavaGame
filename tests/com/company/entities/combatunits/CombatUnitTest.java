package com.company.entities.combatunits;

import com.company.entities.Entity;
import com.company.entities.combatunit.CombatUnit;
import com.company.entities.combatunit.Player;
import com.company.items.Item;
import com.company.items.potions.HealthPotion;
import com.company.items.potions.Potion;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CombatUnitTest {

    private Player player;
    private HealthPotion potion;

    @BeforeClass
    public static void beforeClass(){
    }


    @Before
    public void setUp(){
        player = new Player("Leon");
        potion = new HealthPotion(50);
    }

    @Test
    public void attack_Test(){

    }

    @Test
    public void loseHP_Test(){
        player.setHealthMax(100);
        player.setHealthCurrent(60);
        System.out.println(player.getHealthCurrent());
        player.loseHP(10);
        System.out.println(player.getHealthCurrent());
        System.out.println(player.isDead());
    }

    @Test
    public void gainHp_Test(){
        player.setHealthMax(100);
        player.setHealthCurrent(50);
        System.out.println(player.getHealthCurrent());
        player.gainHP(10);
        System.out.println(player.getHealthCurrent());
        System.out.println(player.isDead());
    }

    @Test
    public void die_Test(){

    }

    @Test
    public void flee_Test(){

    }

    @Test
    public void determineIfCrit_Test(){

    }

    @Test
    public void crit_Test(){

    }

    @Test
    public void block_Test(){

    }

    @Test
    public void dodge_Test(){
    }

}
