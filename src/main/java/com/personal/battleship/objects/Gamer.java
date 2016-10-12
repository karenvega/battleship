package com.personal.battleship.objects;

import java.util.Optional;

/**
 * Clase que representa a un jugador
 * Created by karenvega on 9/30/16.
 */
public class Gamer {

    private int tries;
    private String name;

    public Gamer(int tries) {
        this.tries = tries;
    }

    public Play play(String play) {
        substractTries();
        return new Play(Optional.ofNullable(play));
    }

    private void substractTries() {
        tries--;
    }

    public int getTries() {
        return tries;
    }

    public String getName() {
        return name;
    }

    public void addName(String name) {
        this.name = name;
    }

}
