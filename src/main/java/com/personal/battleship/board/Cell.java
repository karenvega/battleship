package com.personal.battleship.board;

import com.personal.battleship.objects.Ship;

import java.util.Optional;

/**
 * Clase que representa una celda
 * Created by karenvega on 10/09/16.
 */
public abstract class Cell {

    private String content;
    private Optional<Ship> ship;

    public void putShip(Ship ship) {
        this.ship = Optional.ofNullable(ship);
    }

}
