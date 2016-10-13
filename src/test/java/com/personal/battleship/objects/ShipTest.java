package com.personal.battleship.objects;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by karenvega on 12/10/16.
 */
public class ShipTest {

    @Test
    public void testKnockDownAllShip() {
        Ship ship = new Ship(2, "A");
        ship.addCoordinate(new Coordinate(0, 1));
        ship.addCoordinate(new Coordinate(0, 2));
        ship.knockDownPiece(new Coordinate(0, 1));
        ship.knockDownPiece(new Coordinate(0, 2));
        boolean actual = ship.isSunk();
        Assert.assertTrue(actual);
    }

    @Test
    public void testKnockDownCell() {
        Ship ship = new Ship(2, "A");
        ship.addCoordinate(new Coordinate(0, 1));
        ship.addCoordinate(new Coordinate(0, 2));
        ship.knockDownPiece(new Coordinate(0, 1));
        boolean actual = ship.isSunk();
        Assert.assertFalse(actual);
    }
}
