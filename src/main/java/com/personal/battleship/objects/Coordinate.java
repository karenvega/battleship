package com.personal.battleship.objects;

/**
 * Created by karenvega on 10/11/16.
 */
public class Coordinate {

    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object)
    {
        if (object != null && object instanceof Coordinate)
        {
            if (this.x ==  ((Coordinate)object).x && this.y == ((Coordinate)object).y)
             return true;
            return false;
        }

        return false;
    }
}
