package com.personal.battleship.util;

import com.personal.battleship.strategy.*;

import java.util.Random;

/**
 * Utilitarios
 * Created by karenvega on 10/4/16.
 */
public class Util {

    private static Random r = new Random();

    public static int getX(int max) {
        return r.nextInt(max);
    }

    public static int getY(int max) {
        return r.nextInt(max);
    }

    public static Orientation getDirection() {
        int dir = r.nextInt(4);
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
