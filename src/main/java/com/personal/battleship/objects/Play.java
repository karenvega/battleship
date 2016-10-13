package com.personal.battleship.objects;

import java.util.Optional;

/**
 * Clase que representa una jugada.
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
            y = play.get().charAt(0);
            x = play.get().charAt(1);
        }
    }

    private boolean isValidX() {
        return (int)x > 47 && (int)x < 58 ? true : false;
    }

    private boolean isValidY() {
        return (int)y > 64 && (int)y < 91 ? true : false;
    }

    public boolean isValid() {
        return isValidX() && isValidY() ? true : false;
    }

    public int getX() {
        return (int)x - 48;
    }

    public int getY() {
        return (int)y - 65;
    }
}
