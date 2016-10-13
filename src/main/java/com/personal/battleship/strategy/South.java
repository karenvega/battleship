package com.personal.battleship.strategy;

import com.personal.battleship.objects.Coordinate;
import com.personal.battleship.objects.Ship;

import java.util.Set;

/**
 * Estrategia para que un barco se ubique al sur de una posición generada aleatoriamente
 * Created by karenvega on 10/11/16.
 */
public class South implements Orientation {

    @Override
    public boolean isAvailable(Set<Coordinate> occupiedCells, Coordinate coordinate, int shipSize, int gridSize) {
        boolean isAvailable = true;
        if (coordinate.getY() + shipSize <= gridSize) {
            for (int i = coordinate.getY(); i < coordinate.getY() + gridSize; i++) {
                Coordinate newCoordinate = new Coordinate(coordinate.getX(), i);
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
        for (int i = coordinate.getY(); i < coordinate.getY() + ship.getSize(); i++) {
            ship.addCoordinate(new Coordinate(coordinate.getX(), i));
        }
    }
}
