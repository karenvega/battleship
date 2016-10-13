package com.personal.battleship.strategy;

import com.personal.battleship.objects.Coordinate;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * Clase que prueba la estregia de poner el barco al lado este de una coordenada dada
 * Created by karenvega on 12/10/16.
 */
public class EastTest {

    @Test
    public void testIsAvailableEmptyCells() {
        Orientation strategy = new East();
        Set<Coordinate> coordinates = new HashSet<>();
        boolean actual = strategy.isAvailable(coordinates, new Coordinate(4, 4), 3, 10);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsAvailableOcuppiedCells() {
        Orientation strategy = new East();
        Set<Coordinate> coordinates = new HashSet<>();
        coordinates.add(new Coordinate(5, 4));
        boolean actual = strategy.isAvailable(coordinates, new Coordinate(4, 4), 3, 10);
        Assert.assertFalse(actual);
    }
}
