package com.company;

import com.company.items.weapons.Sword;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Sword sword = new Sword("Sword", 20, 15);
        game.getPlayer1().getInventory().addWeaponToInventory(sword);
        game.getPlayer1().wield(sword);
        game.getBoard().printTrueBoard();
        game.movePlayer();
        game.getBoard().printTrueBoard();
        game.movePlayer();
        game.getBoard().printTrueBoard();
        game.movePlayer();
        game.getBoard().printTrueBoard();
    }
}
