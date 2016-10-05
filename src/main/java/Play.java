import java.util.Optional;

/**
 * Created by karenvega on 10/5/16.
 */
public class Play {

    private char x;
    private char y;

    public Play(char x, char y) {
        this.x = x;
        this.y = y;
    }

    public Play(Optional<String> play) {
        if (play.orElse("").length() == 2) {
            x = play.get().charAt(0);
            y = play.get().charAt(1);
        }
    }

    public boolean isValidX() {
        return x > 64 && x < 91 ? true : false;
    }

    public boolean isValidY() {
        return y > 47 && y < 58 ? true : false;
    }

    public boolean isValid() {
        return isValidX() && isValidY() ? true : false;
    }

    public int getX() {
        return x - 65;
    }

    public int getY() {
        return y - 48;
    }
}
