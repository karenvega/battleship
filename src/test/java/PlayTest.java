import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by karenvega on 10/5/16.
 */
public class PlayTest {

    @Test
    public void testValidX() {
        Play play = new Play(Optional.ofNullable("A5"));
        boolean actual = play.isValidX();
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidY() {
        Play play = new Play(Optional.ofNullable("a5"));
        boolean actual = play.isValidY();
        Assert.assertTrue(actual);
    }

    @Test
    public void testInvalidX() {
        Play play = new Play(Optional.ofNullable("a5"));
        boolean actual = play.isValidX();
        Assert.assertFalse(actual);
    }

    @Test
    public void testInvalidY() {
        Play play = new Play(Optional.ofNullable("Ao"));
        boolean actual = play.isValidY();
        Assert.assertFalse(actual);
    }

    @Test
    public void testGetX() {
        Play play = new Play(Optional.ofNullable("A5"));
        int actual = play.getX();
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testGetY() {
        Play play = new Play(Optional.ofNullable("a5"));
        int actual = play.getY();
        Assert.assertEquals(5, actual);
    }
}
