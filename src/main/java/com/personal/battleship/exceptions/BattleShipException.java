package com.personal.battleship.exceptions;

/**
 * Valida las excepciones propias del juego como las siguientes:
 * - Jugador digita una coordenada inválida
 * Created by karenvega on 12/10/16.
 */
public class BattleShipException extends Exception {


    public BattleShipException(String message) {
        super(message);
    }

}
