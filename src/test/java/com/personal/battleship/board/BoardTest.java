package com.personal.battleship.board;

import com.personal.battleship.exceptions.BattleShipException;
import com.personal.battleship.objects.Play;
import com.personal.battleship.objects.Ship;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by karenvega on 12/10/16.
 */
public class BoardTest {

    @Test
    public void testIsGameOverYes() throws BattleShipException {
        Set<Ship> ships = new HashSet<>();
        Ship ship = new Ship(2, "A");
        ships.add(ship);
        Board board = new Board(2, ships);
        board.createBoard();
        board.doMovement(new Play(Optional.ofNullable("A0")));
        board.doMovement(new Play(Optional.ofNullable("A1")));
        board.doMovement(new Play(Optional.ofNullable("B0")));
        board.doMovement(new Play(Optional.ofNullable("B1")));
        boolean actual = board.isGameOver();
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsGameOverNo() throws BattleShipException {
        Set<Ship> ships = new HashSet<>();
        Ship ship = new Ship(2, "A");
        ships.add(ship);
        Board board = new Board(2, ships);
        board.createBoard();
        board.doMovement(new Play(Optional.ofNullable("A0")));
        boolean actual = board.isGameOver();
        Assert.assertFalse(actual);
    }
}
