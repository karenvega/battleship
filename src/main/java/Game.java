/**
 * Created by karenvega on 9/29/16.
 */
public class Game {


    public static void main(String args[]) {
        Game game = new Game();
        Gamer gamer = new Gamer(40);

        Board board = new Board(10, 10);

        Battle portaaviones = new Battle(5, "P");
        Battle acorazado = new Battle(4, "A");
        Battle submarino = new Battle(3, "S");
        Battle destructor = new Battle(3, "D");
        Battle bote = new Battle(2, "B");

        board.display();

        Reader reader = new Reader();
        reader.read();

    }


}
