package com.personal.battleship.strategy;

import com.personal.battleship.objects.Coordinate;
import com.personal.battleship.objects.Ship;

import java.util.Set;

/**
 * Estrategia para que un barco se ubique al oeste de una posición generada aleatoriamente
 * Created by karenvega on 10/11/16.
 */
public class West implements Orientation {

    @Override
    public boolean isAvailable(Set<Coordinate> occupiedCells, Coordinate coordinate, int ShipSize, int gridSize) {
        boolean isAvailable = true;
        if (coordinate.getX() - (ShipSize - 1) >= 0) {
            for (int i = coordinate.getX(); i > coordinate.getX() - ShipSize; i--) {
                Coordinate newCoordinate = new Coordinate(i, coordinate.getY());
                if (occupiedCells.contains(newCoordinate)) {
                    isAvailable = false;
                    break;
                }
            }
            return isAvailable;
        }
        return false;
    }

    @Override
    public void putShip(Ship ship, Coordinate coordinate) {
        for (int i = coordinate.getX(); i > coordinate.getX() - ship.getSize(); i--) {
            ship.addCoordinate(new Coordinate(i, coordinate.getY()));
        }
    }
}
