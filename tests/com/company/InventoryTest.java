package com.company;

import com.company.entities.people.Player;
import com.company.items.armour.Boots;
import com.company.items.armour.Breastplate;
import com.company.items.armour.Helmet;
import com.company.items.armour.Leggings;
import com.company.items.weapons.Sword;
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


    @Before
    public void setUp() {
        player = new Player("Leon");
        testing = new Inventory();
        helmetCloth = new Helmet("Cloth Helm", 1, 1);
        bPlateCloth = new Breastplate("Cloth Chest", 1);
        leggingsCloth = new Leggings("Cloth Legs", 1);
        bootsCloth = new Boots("Cloth Boots", 1, 1);
        sword = new Sword("Wooden Sword", 2);
        player.setInventory(testing);
    }

    @Test
    public void removeAndAddFromInventory_Test() {

        player.getInventory().addArmourToInventory(helmetCloth);
        player.getInventory().addWeaponToInventory(sword);

        Assert.assertTrue(player.getInventory().getListOfWeapons().contains(sword));
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(helmetCloth));
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(bPlateCloth));
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(leggingsCloth));
        Assert.assertTrue(player.getInventory().getListOfArmour().contains(bootsCloth));





    }


}
