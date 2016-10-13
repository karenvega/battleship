package com.personal.battleship.objects;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by karenvega on 12/10/16.
 */
public class PlayTest {

    @Test
    public void testValidPlay() {
        Play play = new Play(Optional.ofNullable("A5"));
        boolean actual = play.isValid();
        Assert.assertTrue(actual);
    }

    @Test
    public void testInvalidPlay() {
        Play play = new Play(Optional.ofNullable("z5"));
        boolean actual = play.isValid();
        Assert.assertFalse(actual);
    }
}
