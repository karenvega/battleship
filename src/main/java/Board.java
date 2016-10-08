/**
 * Created by karenvega on 9/29/16.
 */
public class Board {

    public String grid[][];
    private Battle[] battles = new Battle[5];
    private FillStrategy strategy = new RandomStrategy();

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

    private void putBattles() {
        for (int i = 0; i < 5; i++) {
            Battle battle = battles[i];
            int x = strategy.getX(grid.length);
            int y = strategy.getY(grid.length);
        }
    }

    private void setBattle(Battle battle) {
        for (int i = battle.xInitial; i < battle.xInitial + battle.size; i ++) {
            grid[i][battle.yInitial] = battle.character;
        }
    }


    public boolean isAvailableHR(int x, int y, int battleSize) {
        if (grid[x][y] == "~" && x + battleSize < grid.length) {
            for (int i = 1; i <= battleSize; i++) {
                if (grid[x + i][y] != "~") {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isAvailableHL(int x, int y, int battleSize) {
        if (grid[x][y] == "~" && x - battleSize > 0) {
            for (int i = 1; i <= battleSize; i++) {
                if (grid[x - i][y] != "~") {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isAvailableVU(int x, int y, int battleSize) {
        if (grid[x][y] == "~" && y + battleSize < grid.length) {
            for (int i = 1; i <= battleSize; i++) {
                if (grid[x][y + i] != "~") {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isAvailableVD(int x, int y, int battleSize) {
        if (grid[x][y] == "~" && y - battleSize > 0) {
            for (int i = 1; i <= battleSize; i++) {
                if (grid[x][y - i] != "~") {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    
}
