package com.personal.battleship;

import com.personal.battleship.board.Board;
import com.personal.battleship.exceptions.BattleShipException;
import com.personal.battleship.objects.Gamer;
import com.personal.battleship.objects.Play;
import com.personal.battleship.objects.Ship;
import com.personal.battleship.util.Reader;

import java.util.HashSet;
import java.util.Set;

/**
 * Ejecuta el juego
 * Created by karenvega on 9/29/16.
 */
public class Game {

    public static void main(String args[]) {
        Reader reader = new Reader();
        Gamer gamer = new Gamer(100);
        gamer.addName(reader.read("INGRESE EL ALIAS DEL JUGADOR:"));
        Board board = new Board(10, getShips());
        try {
            board.createBoard();
            board.display();
            while (gamer.getTries() != 0 || !board.isGameOver()) {
                String playLine = reader.read("Por favor digite la coordenada que desea atacar. Ejemplo A5: ");
                Play play  = gamer.play(playLine);
                if (play.isValid()) {
                    board.doMovement(play);
                } else {
                    System.out.println("Jugada Inválida");
                }
                if (gamer.getTries() == 0 || board.isGameOver())
                    break;
                board.display();
            }
            System.out.println(board.isGameOver() ? "Felicidades " + gamer.getName() + ", has GANADO" : "Has agotado el número de intentos. Inténtalo de nuevo");
        } catch (BattleShipException e) {
            System.out.println(e.getMessage());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static Set<Ship> getShips() {
        Ship aircraftCarrier = new Ship(5, "P");
        Ship battleship = new Ship(4, "A");
        Ship submarine = new Ship(3, "S");
        Ship destroyer = new Ship(3, "D");
        Ship smallBoat = new Ship(2, "B");
        Set<Ship> ships = new HashSet<>();
        ships.add(aircraftCarrier);
        ships.add(battleship);
        ships.add(submarine);
        ships.add(destroyer);
        ships.add(smallBoat);
        return ships;
    }


}
