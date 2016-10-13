package com.personal.battleship.objects;

import com.personal.battleship.strategy.Orientation;
import com.personal.battleship.util.Util;

import java.util.*;

/**
 * Clase que representa un barco
 * Created by karenvega on 9/29/16.
 */
public class Ship {

    /* Tamaña del barco */
    private int size;

    /* Caracter que representa al barco*/
    private String character;

    /** Bandera que indica si el barco ya fue hundido **/
    private boolean isSunk = false;

    private Orientation strategy;

    private Map<Coordinate, Boolean> sunkCoordinates = new HashMap<>();

    private Set<Coordinate> occupiedCells = new HashSet<>();


    /**
     * Constructor
     * @param size size of the battle
     */
    public Ship(int size, String character) {
        this.size = size;
        this.character = character;
        strategy = Util.getDirection();
    }

    public Orientation getStrategy() {
        return strategy;
    }

    public void addCoordinate(Coordinate coordinate) {
        occupiedCells.add(coordinate);
        sunkCoordinates.put(coordinate, Boolean.FALSE);
    }

    public void knockDownPiece(Coordinate coordinate) {
        sunkCoordinates.put(coordinate, Boolean.TRUE);
        updateStatus();
    }

    public boolean isSunk() {
        return isSunk;
    }

    private void updateStatus() {
        isSunk = true;
        for (Coordinate key : occupiedCells) {
            if (!sunkCoordinates.get(key)) {
                isSunk = false;
                break;
            }
        }
    }

    public Set<Coordinate> getCoordinates() {
        return occupiedCells;
    }

    public String getCharacter() {
        return character;
    }

    public int getSize() {
        return size;
    }

}
