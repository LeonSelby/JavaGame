package com.company;

import com.company.entities.combatunit.Player;
import com.company.items.armour.*;
import com.company.items.potions.HealthPotion;
import com.company.items.potions.Potion;
import com.company.items.scrolls.Map;
import com.company.items.scrolls.Scroll;
import com.company.items.weapons.Sword;
import com.company.items.weapons.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InventoryTest {

    private Player player;
    private Inventory testing;
    private Helmet helmetCloth;
    private Breastplate bPlateCloth;
    private Leggings leggingsCloth;
    private Boots bootsCloth;
    private Sword sword;
    private Map map;
    private HealthPotion healthPotion;


    @Before
    public void setUp() {
        player = new Player("Leon");
        testing = new Inventory();
        helmetCloth = new Helmet("Cloth Helm", 15, 1, 1);
        bPlateCloth = new Breastplate("Cloth Chest", 25, 1);
        leggingsCloth = new Leggings("Cloth Legs", 20, 1);
        bootsCloth = new Boots("Cloth Boots", 20, 1, 1);
        sword = new Sword("Wooden Sword", 25, 2);
        map = new Map();
        healthPotion = new HealthPotion(50);
        player.setInventory(testing);
    }

    @Test
    public void removeAndAddFromInventory_Test() {
        player.getInventory().addArmourToInventory(helmetCloth);
        player.getInventory().addArmourToInventory(bPlateCloth);
        player.getInventory().addArmourToInventory(leggingsCloth);
        player.getInventory().addArmourToInventory(bootsCloth);
        player.getInventory().addPotionToInventory(healthPotion);
        player.getInventory().addWeaponToInventory(sword);
        player.getInventory().addScrollToInventory(map);

        Assert.assertTrue(player.getInventory().getListOfWeapons().contains(sword));
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(helmetCloth));
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(bPlateCloth));
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(leggingsCloth));
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(bootsCloth));
        Assert.assertTrue(player.getInventory().getListOfPotions().contains(healthPotion));
        Assert.assertTrue(player.getInventory().getListOfScrolls().contains(map));

        player.getInventory().removeArmourFromInventory(helmetCloth);
        player.getInventory().removeScrollFromInventory(map);
        Assert.assertFalse(player.getInventory().getListOfScrolls().contains(map));
    }

    @Test
    public void removeItemFromInventory_Test(){
        player.getInventory().addWeaponToInventory(sword);
        player.getInventory().removeItemFromInventory(sword);
        Assert.assertFalse(player.getInventory().checkIfItemIsPresent(sword));
    }

    @Test
    public void addItemToInventory_Test(){
        player.getInventory().addItemToInventory(sword);
        Assert.assertTrue(player.getInventory().checkIfItemIsPresent(sword));
    }

    @Test
    public void checkIfItemIsPresent_Test() {
        player.getInventory().addArmourToInventory(leggingsCloth);
        Assert.assertTrue(player.getInventory().checkIfItemIsPresent(leggingsCloth));
    }

    @Test
    public void reportStats_Test(){}

    @Test
    public void addAndRemoveCoins_Test(){
        player.getInventory().addCoins(50);
        Assert.assertEquals(player.getInventory().getCoinsInBag(), 50);
        player.getInventory().removeCoins(50);
        Assert.assertEquals(player.getInventory().getCoinsInBag(), 0);
    }

    @Test
    public void search_Test(){

    }

    @Test
    public void checkIfCanAfford_Test(){
        player.getInventory().addCoins(10);
        Assert.assertTrue(player.getInventory().checkIfCanAfford(9));
        Assert.assertFalse(player.getInventory().checkIfCanAfford(19));
        player.getInventory().addCoins(10);
        Assert.assertTrue(player.getInventory().checkIfCanAfford(helmetCloth));
    }


}
