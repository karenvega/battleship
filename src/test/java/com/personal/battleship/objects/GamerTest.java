package com.personal.battleship.objects;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by karenvega on 12/10/16.
 */
public class GamerTest {

    @Test
    public void testSubstractTries() {
        Gamer gamer = new Gamer(10);
        gamer.play("A5");
        gamer.play("B8");
        gamer.play("Z1");
        int actualTries = gamer.getTries();
        Assert.assertEquals(7, actualTries);
    }
}
