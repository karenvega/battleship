package com.personal.battleship.util;

import com.personal.battleship.strategy.*;

/**
 * Utilitarios
 * Created by karenvega on 10/4/16.
 */
public class Util {

    public static int getX(int max) {
        return (int) (Math.random() * max);
    }

    public static int getY(int max) {
        return (int) (Math.random() * max);
    }

    public static Orientation getDirection() {
        int dir = (int) (Math.random() * 4);
        switch (dir) {
            case 1:
                return new North();
            case 2:
                return new South();
            case 3:
                return new West();
            case 4:
                return new East();
            default:
                return new East();
        }
    }


}
