import org.junit.Assert;
import org.junit.Test;


/**
 * Test of the random strategy
 * Created by karenvega on 10/4/16.
 */
public class RandomStrategyTest {

    @Test
    public void testGetX() {
        FillStrategy rs = new RandomStrategy();
        int actual = rs.getX(10);
        Assert.assertTrue(actual > -1 && actual < 10);
    }

    @Test
    public void testGetY() {
        FillStrategy rs = new RandomStrategy();
        int actual = rs.getY(10);
        Assert.assertTrue(actual > -1 && actual < 10);
    }

}
