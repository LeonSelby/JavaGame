package com.company;

import java.util.ArrayList;
import java.util.List;

public class GameUtility {
    private List<Integer> listOfUnMoveableTiles = new ArrayList<>();
    private List<Integer> listOfInteractableTiles = new ArrayList<>();


    public GameUtility() {
        this.listOfUnMoveableTiles.add(-1);
        this.listOfUnMoveableTiles.add(1);
        this.listOfUnMoveableTiles.add(2);
        this.listOfUnMoveableTiles.add(6);
        this.listOfUnMoveableTiles.add(10);
        this.listOfUnMoveableTiles.add(5);

        this.listOfInteractableTiles.add(1);
        this.listOfInteractableTiles.add(2);
        this.listOfInteractableTiles.add(5);
        this.listOfInteractableTiles.add(6);
        this.listOfInteractableTiles.add(10);
    }


    public List<Integer> getListOfUnMoveableTiles() {
        return this.listOfUnMoveableTiles;
    }

    public List<Integer> getListofInteractableTiles() {
        return this.listOfInteractableTiles;
    }
}
