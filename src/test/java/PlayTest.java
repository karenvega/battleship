import com.personal.battleship.objects.Play;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by karenvega on 10/5/16.
 */
public class PlayTest {



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
