package com.personal.battleship.strategy;

import com.personal.battleship.objects.Ship;

/**
 * Estrategia para que un barco se ubique al sur de una posición generada aleatoriamente
 * Created by karenvega on 10/11/16.
 */
public class South implements FillStrategy {

    @Override
    public boolean isAvailable(String grid[][], int x, int y, int size) {
        if (grid[x][y] == "~" && y - size > 0) {
            for (int i = 1; i <= size; i++) {
                if (grid[x][y - i] != "~") {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void putBattle(String[][] grid, Ship battle, int x, int y) {
        for (int i = 0; i < y + battle.size; i++) {
            grid[x][i] = battle.character;
        }
    }
}
