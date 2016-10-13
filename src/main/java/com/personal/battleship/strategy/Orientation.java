package com.personal.battleship.strategy;

import com.personal.battleship.objects.Coordinate;
import com.personal.battleship.objects.Ship;

import java.util.Set;

/**
 * Representa la orientación que tiene un barco
 * Created by karenvega on 9/30/16.
 */
public interface Orientation {

    /**
     * Evalúa si es posible ubicar un barco en la coordenada seleccionada
     * @param occupiedCells celdas que ya se encuentran ocupadas
     * @param coordinate Coordenada seleccionada por el usuario
     * @param shipSize tamaño del barco a ubicar
     * @param gridSize tamaño del tablero
     * @return true si es posible ubicar el barco, false en caso contrario
     */
    boolean isAvailable(Set<Coordinate> occupiedCells, Coordinate coordinate, int shipSize, int gridSize);

    /**
     * Ubica el barco en la coordenada seleccionada
     * @param ship Barco a ubicar
     * @param coordinate coordenada inicial
     */
    void putShip(Ship ship, Coordinate coordinate);

}
