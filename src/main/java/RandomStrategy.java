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

    public String getDirection() {
        int dir = (int) (Math.random() * 4);
        switch (dir) {
            case 1:
                return "HORIZONTAL_RIGHT";
            case 2:
                return "HORIZONTAL_LEFT";
            case 3:
                return "VERTICAL_UP";
            case 4:
                return "VERTICAL_DOWM";
            default:
                return "HORIZONTAL";
        }
    }


}
