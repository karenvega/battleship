import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by karenvega on 10/4/16.
 */
public class BoardTest {

    @Test
    public void testAvailable() {
        Board board = new Board(10, 10);
        boolean actual = board.isAvailableHR(3, 4, 5);
        Assert.assertTrue(actual);
    }

    @Test
    public void testUnavailableIndexOfBounds() {
        Board board = new Board(10, 10);
        boolean actual = board.isAvailableHR(8, 4, 5);
        Assert.assertFalse(actual);
    }

    @Test
    public void testUnavailableBlockOccupied() {
        Board board = new Board(10, 10);
        board.grid[3][4] = "P";
        boolean actual = board.isAvailableHR(8, 4, 5);
        Assert.assertFalse(actual);
    }


}
