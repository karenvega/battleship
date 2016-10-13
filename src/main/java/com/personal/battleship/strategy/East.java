package com.personal.battleship.strategy;

import com.personal.battleship.objects.Coordinate;
import com.personal.battleship.objects.Ship;

import java.util.Set;

/**
 * Estrategia para que un barco se ubique al este de una posición generada aleatoriamente
 * Created by karenvega on 10/11/16.
 */
public class East implements Orientation {

//    @Override
//    public boolean isAvailable(String grid[][], Coordinate coordinate, int size) {
//        if (grid[coordinate.x][coordinate.y] == "~" && coordinate.x - size > 0) {
//            for (int i = 0; i < size; i++) {
//                if (grid[coordinate.x - i][coordinate.y] != "~") {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean isAvailable(Set<Coordinate> occupiedCells, Coordinate coordinate, int shipSize, int gridSize) {
        boolean isAvailable = true;
        if (coordinate.getX() + shipSize <= gridSize) {
            for (int i = coordinate.getX(); i < coordinate.getX() + gridSize; i++) {
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
        for (int i = coordinate.getX(); i < coordinate.getX() + ship.getSize(); i++) {
            ship.addCoordinate(new Coordinate(i, coordinate.getY()));
        }
    }
}
