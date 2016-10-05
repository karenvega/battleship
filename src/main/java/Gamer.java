/**
 * Created by karenvega on 9/30/16.
 */
public class Gamer {

    private int tries;

    public Gamer(int tries) {
        this.tries = tries;
    }

    public void play(String play) {

    }

    private void substractTries() {
        tries--;
    }

    public int getTries() {
        return tries;
    }

}
