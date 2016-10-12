package com.personal.battleship.strategy;

import com.personal.battleship.objects.Coordinate;
import com.personal.battleship.objects.Ship;

/**
 * Estrategia para que un barco se ubique al este de una posición generada aleatoriamente
 * Created by karenvega on 10/11/16.
 */
public class East implements FillStrategy {

    @Override
    public boolean isAvailable(String grid[][], int x, int y, int size) {
        if (grid[x][y] == "~" && x - size > 0) {
            for (int i = 0; i < size; i++) {
                if (grid[x - i][y] != "~") {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void putBattle(String[][] grid, Ship battle, int x, int y) {
        for (int i = x; i > x - battle.size; i--) {
            //grid[i][y] = battle.character;
            battle.ponerBarco(new Coordinate(i, y));
        }
    }
}
