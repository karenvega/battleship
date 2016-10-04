/**
 * Object that represents a generic battle
 * Created by karenvega on 9/29/16.
 */
public class Battle {

    /* Size of the battle */
    public int size;

    /* Character that indicates what type of battle is*/
    public String character;

    /* Flag that indicates if the battle was sunk */
    public boolean isSank;

    /* Initial position in the x coordinate */
    public int xInitial;

    /* Initial position in the y coordinate */
    public int yInitial;

    /* Indicates if the battle is located in horizontal or vertical */
    public Direction direction;

    /**
     * Constructor
     * @param size size of the battle
     */
    public Battle(int size, String character) {
        this.size = size;
        this.character = character;
    }
}
