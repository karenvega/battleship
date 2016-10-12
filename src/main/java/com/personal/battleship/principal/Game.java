package com.personal.battleship.principal;

import com.personal.battleship.board.Board;
import com.personal.battleship.objects.Gamer;
import com.personal.battleship.objects.Ship;
import com.personal.battleship.util.Reader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karenvega on 9/29/16.
 */
public class Game {


    public static void main(String args[]) {
        Game game = new Game();
        Reader reader = new Reader();
        Gamer gamer = new Gamer(10);

        Ship portaaviones = new Ship(5, "P");
        Ship acorazado = new Ship(4, "A");
        Ship submarino = new Ship(3, "S");
        Ship destructor = new Ship(3, "D");
        Ship bote = new Ship(2, "B");
        List<Ship> battles = new ArrayList<>();
        battles.add(portaaviones);
        battles.add(acorazado);
        battles.add(submarino);
        battles.add(destructor);
        battles.add(bote);
        Board board = new Board(10, 10, battles);
        board.display();

        while (gamer.getTries() != 0) {
            String play = reader.read();
            board.doMovement(gamer.play(play));
            board.display();
        }

    }


}
