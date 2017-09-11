package com.company.entities.combatunits;

import com.company.Inventory;
import com.company.entities.combatunit.Player;
import com.company.items.potions.HealthPotion;
import com.company.items.weapons.Sword;
import com.company.items.weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;
    private HealthPotion potion;
    private Sword sword;
    private Sword sword2;

    @Before
    public void setUp(){
        player = new Player("Leon");
        potion = new HealthPotion(50);
        sword = new Sword("test", 20, 3);
        sword2 = new Sword("replaced test", 30, 5);

    }

    @Test
    public void move_Test(){

    }

    @Test
    public void buy_Test(){

    }

    @Test
    public void sell_Test(){

    }

    @Test
    public void equip_Test(){

    }

    @Test
    public void unequip_Test(){

    }

    @Test
    public void wield_Test(){
        player.getInventory().addWeaponToInventory(sword);
        player.getEquippedWeapon().add(sword2);
        System.out.println(player.getEquippedWeapon().get(0).getName() + " is equipped");
        System.out.println(player.getInventory().getListOfWeapons().get(0).getName() + " is in Inv");

        player.wield(sword);

        System.out.println(player.getInventory().getListOfWeapons().get(0).getName() + " is in Inv");
        System.out.println(player.getEquippedWeapon().get(0).getName() + " is equipped");

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

    }

    @Test
    public void takeHpPotion_Test(){
        player.setHealthMax(100);
        player.setHealthCurrent(70);
        player.getInventory().addPotionToInventory(potion);

        System.out.println(player.getInventory().getListOfPotions());
        System.out.println(player.getHealthCurrent());

        player.takeHpPotion(potion);

        System.out.println(player.getHealthCurrent());
        System.out.println(player.getInventory().getListOfPotions());
    }

    @Test
    public void getATKRating_Test(){

    }

    @Test
    public void getDEFRating_Test(){

    }
}
