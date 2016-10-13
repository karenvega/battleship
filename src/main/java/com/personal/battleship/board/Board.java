package com.personal.battleship.board;

import com.personal.battleship.exceptions.BattleShipException;
import com.personal.battleship.objects.Coordinate;
import com.personal.battleship.objects.Play;
import com.personal.battleship.objects.Ship;
import com.personal.battleship.util.Util;

import java.util.*;

/**
 * Representa el tablero con los botes
 * Created by karenvega on 9/29/16.
 */
public class Board {

    private String grid[][];
    private Set<Ship> ships = new HashSet<>();
    private Set<Coordinate> occupiedCells = new HashSet<>();
    private final String EMPTY_CELL = "~";
    private final String UNCOVERED_EMPTY_CELL = ".";
    private final String UNCOVERED_OCCUPIED_CELL = "X";

    public Board(int size, Set<Ship> ships) {
        this.ships = ships;
        grid = BoardFactory.createEmptyBoard(size, EMPTY_CELL);
    }

    /**
     * Muestra en pantalla el tablero
     */
    public void display() {
        System.out.println("    ABCDEFGHIJ");
        System.out.println("   +----------");
        for (int x = 0; x < grid.length; x++) {
            System.out.print(x + " | ");
            for (int y = 0; y < grid.length; y++) {
                System.out.print(grid[x][y]);
            }
            System.out.println();
        }
    }

    /**
     * Construye el tablero con los barcos
     * @throws BattleShipException
     */
    public void createBoard() throws BattleShipException {
        for (Ship ship: ships) {
            Coordinate coor = getRandomCoordinate(ship);
            ship.getStrategy().putShip(ship, coor);
            occupiedCells.addAll(ship.getCoordinates());
        }
    }

    /**
     * Obtiene la coordenada inicial en la que se va a ubicar el barco
     * @param ship Barco que va a ser ubicado
     * @return Coordinate coordenada inicial en la que se ubicará el barco
     * @throws BattleShipException
     */
    private Coordinate getRandomCoordinate(Ship ship) throws BattleShipException{
        for (int i = 0; i < 20; i++) {
            int x = Util.getX(grid.length);
            int y = Util.getY(grid.length);
            Coordinate coordinate = new Coordinate(x, y);
            if (ship.getStrategy().isAvailable(occupiedCells, coordinate, ship.getSize(), grid.length)) {
                return coordinate;
            }
        }
        throw new BattleShipException("No fue posible ubicar el barco. Detenga el juego y vuelva a iniciarlo");
    }

    /**
     * Descubre la celda seleccionada
     * @param play Jugada realizada
     */
    public void doMovement(Play play) {
        Coordinate coordinate = new Coordinate(play.getX(), play.getY());
        Optional<Ship> shipHitted = getHittedShip(coordinate);
        Optional<String> charToPut = getCharacterToUpdate(shipHitted, coordinate);
        if (charToPut.isPresent()) {
            grid[coordinate.getX()][coordinate.getY()] = charToPut.get();
        } else {
            updateShipInGrid(shipHitted.get());
        }
    }

    /**
     * Obtiene el caracter que se debe poner en la celda descubierta.
     * @param shipHitted Barco que ha sido atacado
     * @param coordinate Coordenada en la que se encuentra el barco atacado
     * @return caracter con el que se debe actualizar la celda. Si es vacío indica que todas las casillas del barco se descubrieron
     */
    private Optional<String> getCharacterToUpdate(Optional<Ship> shipHitted, Coordinate coordinate) {
        if (shipHitted.isPresent()) {
            shipHitted.get().knockDownPiece(coordinate);
            return shipHitted.get().isSunk() ? Optional.empty() : Optional.ofNullable(UNCOVERED_OCCUPIED_CELL);
        } else {
            return Optional.ofNullable(UNCOVERED_EMPTY_CELL);
        }
    }

    /**
     * Busca en la lista de barcos el que ha sido atacado
     * @param coordinate Coordenada que se ha atacado
     * @return Ship El barco atacado que se ha atacado. Si retorna vacío es porque en la celda no había barco
     */
    private Optional<Ship> getHittedShip(Coordinate coordinate) {
        for (Ship ship: ships) {
            if (ship.getCoordinates().contains(coordinate))
                return Optional.ofNullable(ship);
        }
        return Optional.empty();
    }

    /**
     * Actualiza todas las celdas que ocupa un barco cuando este ha sido hundido completamente
     * @param ship Barco hundido
     */
    public void updateShipInGrid(Ship ship) {
        for (Coordinate c: ship.getCoordinates()) {
            grid[c.getX()][c.getY()] = ship.getCharacter();
        }
    }

    /**
     * Evalúa si ya se hundieron todos los barcos
     * @return true si ya todos los barcos fueron hundidos, false en caso contrario
     */
    public boolean isGameOver() {
        for (Ship ship: ships) {
            if (ship.isSunk()) {
                continue;
            }
            return false;
        }
        return true;
    }

}
