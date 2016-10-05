/**
 * Created by karenvega on 9/29/16.
 */
public class Board {

    private String grid[][];
    private Battle[] battles = new Battle[5];

    public Board(int high, int width) {
        grid = new String[width][high];
        initialize();
    }

    public void display() {
        System.out.println("    ABCDEFGHIJ");
        System.out.println("   +----------");
        for (int i = 0; i < grid.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]);
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



    private void anything(Battle battle, int x, int y) {
        switch (battle.direction) {
            case VERTICAL:
                break;
            case HORIZONTAL:
                break;
        }
    }

    private void other(Battle battle, int x, int y) {
        if (!battle.isSank) {
            if (x >= battle.xInitial && x <= battle.xInitial + battle.size) {
                grid[x][y] = "X";
            }
            if (y >= battle.yInitial && x <= battle.yInitial + battle.size) {
                grid[x][y] = "X";
            }
        }
    }

}
