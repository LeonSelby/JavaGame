package com.company.entities.combatunits;

import com.company.entities.Entity;
import com.company.entities.combatunit.CombatUnit;
import com.company.entities.combatunit.Enemy;
import com.company.entities.combatunit.Player;
import com.company.entities.combatunit.enemies.Orc;
import com.company.items.Item;
import com.company.items.armour.Helmet;
import com.company.items.potions.HealthPotion;
import com.company.items.potions.Potion;
import com.company.items.weapons.Sword;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CombatUnitTest {

    private Player player;
    private Orc orc;
    private HealthPotion potion;
    private Sword sword;
    private Helmet helmet;


    @BeforeClass
    public static void beforeClass() {
    }


    @Before
    public void setUp() {
        player = new Player("Leon");
        potion = new HealthPotion(50);
        orc = new Orc("Orc", 100, 1, 1);
        sword = new Sword("Test", 30, 5);
        helmet = new Helmet("Cloth Helm", 15, 1, 1);
    }

    @Test
    public void attack_Test() {
        player.setHealthMax(100);
        player.setHealthCurrent(100);
        player.getInventory().addWeaponToInventory(sword);
        player.wield(sword);
        player.attack(orc);
        Assert.assertEquals(orc.getHealthMax() - orc.getHealthCurrent(), player.getAtkRating() - orc.getDefRating());
    }

    @Test
    public void loseHP_Test() {
        player.setHealthMax(100);
        player.setHealthCurrent(60);
        player.loseHP(10);
        Assert.assertEquals(player.getHealthCurrent(), 50);
        Assert.assertFalse(player.isDead());
    }

    @Test
    public void gainHp_Test() {
        player.setHealthMax(100);
        player.setHealthCurrent(50);
        player.gainHP(10);
        Assert.assertEquals(player.getHealthCurrent(), 60);
        Assert.assertFalse(player.isDead());
    }

    @Test
    public void die_Test() {

    }

    @Test
    public void flee_Test() {

    }

}
