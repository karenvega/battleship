package com.personal.battleship.objects;

import com.personal.battleship.strategy.FillStrategy;
import com.personal.battleship.util.Util;

import java.util.*;

/**
 * Clase que representa a un bot
 * Created by karenvega on 9/29/16.
 */
public class Ship {

    /* Size of the battle */
    public int size;

    /* Character that indicates what type of battle is*/
    public String character;

    private FillStrategy strategy;

    private Map<Coordinate, Boolean> coordinatesSank = new HashMap<>();

    private List<Coordinate> coordinates = new ArrayList<>();


    /**
     * Constructor
     * @param size size of the battle
     */
    public Ship(int size, String character) {
        this.size = size;
        this.character = character;
        strategy = Util.getDirection();
    }

    public FillStrategy getStrategy() {
        return strategy;
    }

    public void ponerBarco(Coordinate coordinate) {
        coordinates.add(coordinate);
        coordinatesSank.put(coordinate, Boolean.FALSE);
    }

    public void downPiece(Play play){
        Set<Coordinate> keys = coordinatesSank.keySet();
        for (Coordinate key : keys) {
            if (key.x == play.getX() && key.y == play.getY()) {
                coordinatesSank.put(key, Boolean.TRUE);
            }
        }
    }

    public boolean isSank() {
        Set<Coordinate> keys = coordinatesSank.keySet();
        for (Coordinate key : keys) {
            System.out.println(coordinatesSank.get(key));
            if (Boolean.FALSE == coordinatesSank.get(key)) {
                return false;
            }
        }
        return true;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }


}
