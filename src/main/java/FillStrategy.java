/**
 * Created by karenvega on 9/30/16.
 */
public interface FillStrategy {

    public void putBattle(Battle battle);

    public int getX(int max);

    public int getY(int max);

    public String getDirection();

}
