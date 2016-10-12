package com.personal.battleship.board;

import com.personal.battleship.objects.Play;
import com.personal.battleship.objects.Ship;
import com.personal.battleship.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el tablero con los botes
 * Created by karenvega on 9/29/16.
 */
public class Board {

    public String grid[][];
    private static int high;
    private static int width;
    private List<Ship> battles = new ArrayList<>();

    public Board(int high, int width, List<Ship> battles) {
        this.high = high;
        this.width = width;
        this.battles = battles;
        grid = new String[width][high];
        initialize();
        createBoard();
    }

    public void display() {
        System.out.println("    ABCDEFGHIJ");
        System.out.println("   +----------");
        for (int x = 0; x < width; x++) {
            System.out.print(x + " | ");
            for (int y = 0; y < high; y++) {
                System.out.print(grid[x][y]);
            }
            System.out.println();
        }
    }

    private void initialize() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = "~";
            }
        }
    }

    public void createBoard() {
        for (int i = 0; i < battles.size(); i++) {
            Ship battle = battles.get(i);
            int x = Util.getX(width);
            int y = Util.getY(high);
            while (!battle.getStrategy().isAvailable(grid, x, y, battle.size)) {
                x = Util.getX(width);
                y = Util.getY(high);
            }
            battle.getStrategy().putBattle(grid, battle, x, y);

        }
    }

    public void doMovement(Play play) {
        int x = play.getX();
        int y = play.getY();
        if ("~".equals(grid[x][y]) && ".".equals(grid[x][y])) {
            grid[x][y] = ".";
        } else {
            grid[x][y] = searchShip(play);
        }
    }

    public String searchShip(Play coordinate) {
        for (int i = 0; i < battles.size(); i++) {
            Ship ship = battles.get(i);
            if (ship.getCoordinates().contains(coordinate)) {
                if (ship.isSank()) {
                    return ship.character;
                }
                return "X";
            }
        }
        return ".";
    }

}
