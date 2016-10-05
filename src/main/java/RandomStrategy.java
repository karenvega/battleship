/**
 * Created by karenvega on 10/4/16.
 */
public class RandomStrategy implements FillStrategy {

    public void putBattle(Battle battle) {

    }

    public int getX(int max) {
        return (int) (Math.random() * max);
    }

    public int getY(int max) {
        return (int) (Math.random() * max);
    }
}
