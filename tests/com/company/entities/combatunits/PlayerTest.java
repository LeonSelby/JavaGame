package com.company.entities.combatunits;

import com.company.Inventory;
import com.company.entities.combatunit.Player;
import com.company.items.armour.Boots;
import com.company.items.armour.Breastplate;
import com.company.items.armour.Helmet;
import com.company.items.armour.Leggings;
import com.company.items.potions.HealthPotion;
import com.company.items.scrolls.Map;
import com.company.items.scrolls.Scroll;
import com.company.items.weapons.Sword;
import com.company.items.weapons.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;
    private HealthPotion potion;
    private Sword sword;
    private Sword sword2;
    private Helmet helmet;
    private Helmet helmet2;
    private Breastplate chest;
    private Leggings leggings;
    private Boots boots;
    private Map map;

    @Before
    public void setUp(){
        player = new Player("Leon");
        potion = new HealthPotion(50);
        sword = new Sword("test", 20, 3);
        sword2 = new Sword("replaced test", 30, 5);
        helmet = new Helmet("Cloth Helm", 15, 1, 1);
        helmet2 = new Helmet("Cloth Helm", 15, 1, 1);
        chest = new Breastplate("Cloth Chest", 25, 1);
        leggings = new Leggings("Cloth Legs", 20, 1);
        boots = new Boots("Cloth Boots", 20, 1, 1);
        map = new Map();
    }

    @Test
    public void move_Test(){

    }

    @Test
    public void buy_Test(){
        player.getInventory().addCoins(30);
        player.buy(helmet);
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(helmet));
        Assert.assertEquals(player.getInventory().getCoinsInBag(), 15);
        player.buy(helmet);
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(helmet));
        Assert.assertEquals(player.getInventory().getCoinsInBag(), 0);
    }

    @Test
    public void sell_Test(){
        player.getInventory().addArmourToInventory(helmet);
        player.sell(helmet);
        Assert.assertFalse(player.getInventory().getListOfArmour().contains(helmet));
        Assert.assertEquals(player.getInventory().getCoinsInBag(), 15);

        player.getInventory().addArmourToInventory(boots);
        player.sell(boots);
        Assert.assertFalse(player.getInventory().getListOfArmour().contains(boots));
        Assert.assertEquals(player.getInventory().getCoinsInBag(), 35);

        player.getInventory().addScrollToInventory(map);
        player.sell(map);
        Assert.assertFalse(player.getInventory().getListOfScrolls().contains(map));
        Assert.assertEquals(player.getInventory().getCoinsInBag(), 85);

        player.getInventory().addPotionToInventory(potion);
        player.sell(potion);
        Assert.assertFalse(player.getInventory().getListOfPotions().contains(potion));
        Assert.assertEquals(player.getInventory().getCoinsInBag(), 105);

        player.getInventory().addWeaponToInventory(sword);
        player.sell(sword);
        Assert.assertFalse(player.getInventory().getListOfWeapons().contains(sword));
        Assert.assertEquals(player.getInventory().getCoinsInBag(), 125);

        player.sell(sword2);
        System.out.println(player.getInventory().getCoinsInBag());
    }

    @Test
    public void equip_Test(){
        player.getInventory().addArmourToInventory(helmet);
        player.getEquippedArmour().add(helmet2);
        player.equip(helmet);

        Assert.assertTrue(player.getEquippedArmour().contains(helmet));
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(helmet2));

    }

    @Test
    public void unequip_Test(){
        player.getEquippedArmour().add(helmet);
        player.unequip(helmet);
        Assert.assertFalse(player.getEquippedArmour().contains(helmet));
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(helmet));
    }

    @Test
    public void wield_Test(){
        player.getInventory().addWeaponToInventory(sword);
        player.getEquippedWeapon().add(sword2);
        System.out.println(player.getEquippedWeapon().get(0).getName() + " is equipped");
        System.out.println(player.getInventory().getListOfWeapons().get(0).getName() + " is in Inv");
        Assert.assertFalse(player.getInventory().getListOfWeapons().contains(sword2));
        Assert.assertFalse(player.getEquippedWeapon().contains(sword));
        player.wield(sword);
        System.out.println(player.getInventory().getListOfWeapons().get(0).getName() + " is in Inv");
        System.out.println(player.getEquippedWeapon().get(0).getName() + " is equipped");
        Assert.assertTrue(player.getInventory().getListOfWeapons().contains(sword2));
        Assert.assertTrue(player.getEquippedWeapon().contains(sword));
        Assert.assertFalse(player.getInventory().getListOfWeapons().contains(sword));
        Assert.assertFalse(player.getEquippedWeapon().contains(sword2));
    }

    @Test
    public void unWield_Test(){
        player.getEquippedWeapon().add(sword);
        System.out.println(player.getEquippedWeapon().get(0).getName() + " is equipped");

        player.unWield(sword);

        for (Weapon w : player.getEquippedWeapon()) {
            System.out.println(w.getName() + " is equipped after the test.");
        }
        for (Weapon w : player.getInventory().getListOfWeapons()) {
            System.out.println(w.getName() + " is in the Inv.");
        }

        Assert.assertTrue(player.getInventory().getListOfWeapons().contains(sword));
        Assert.assertFalse(player.getEquippedWeapon().contains(sword));
    }

    @Test
    public void takeHpPotion_Test(){
        player.setHealthMax(100);
        player.setHealthCurrent(70);
        player.getInventory().addPotionToInventory(potion);

        player.takeHpPotion();

        Assert.assertEquals(player.getHealthCurrent(), 100);
        System.out.println(player.getInventory().getListOfPotions());
        Assert.assertTrue(player.getInventory().getListOfPotions().isEmpty());
    }

    @Test
    public void getATKRating_Test(){
        player.getInventory().addWeaponToInventory(sword);
        player.wield(sword);
        Assert.assertEquals(player.getAtkRating(), 4);
    }

    @Test
    public void getDEFRating_Test(){
        player.getEquippedArmour().add(helmet);
        player.getEquippedArmour().add(chest);
        player.getEquippedArmour().add(leggings);
        player.getEquippedArmour().add(boots);
        Assert.assertEquals(player.getDefRating(), 5);
    }
}
