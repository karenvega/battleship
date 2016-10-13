package com.personal.battleship.objects;

/**
 * Coordenada del tablero
 * Created by karenvega on 10/11/16.
 */
public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    @Override
    public int hashCode()
    {
        return String.valueOf(x).hashCode() + String.valueOf(y).hashCode();
    }
}
