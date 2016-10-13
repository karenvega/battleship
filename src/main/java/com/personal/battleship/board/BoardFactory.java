package com.personal.battleship.board;

/**
 * Created by karenvega on 12/10/16.
 */
public class BoardFactory {

    public static String[][] createEmptyBoard(int size, String emptyCellMessage) {
        String[][] grid = new String[size][size];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                grid[x][y] = emptyCellMessage;
            }
        }
        return grid;
    }
}
