package com.personal.battleship.strategy;

import com.personal.battleship.objects.Coordinate;
import com.personal.battleship.objects.Ship;

/**
 * Estrategia para que un barco se ubique al oeste de una posición generada aleatoriamente
 * Created by karenvega on 10/11/16.
 */
public class West implements FillStrategy {

    @Override
    public boolean isAvailable(String grid[][], int x, int y, int size) {
        if (grid[x][y] == "~" && x + size < grid.length) {
            for (int i = 0; i < size; i++) {
                if (grid[x + i][y] != "~") {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void putBattle(String[][] grid, Ship ship, int x, int y) {
        for (int i = x; i < x + ship.size; i++) {
            grid[i][y] = ship.character;
            ship.ponerBarco(new Coordinate(i, y));
        }
    }
}
