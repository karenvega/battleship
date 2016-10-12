package com.personal.battleship.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by karenvega on 9/30/16.
 */
public class Reader {

    public String read() {
        System.out.println("Por favor digite la coordenada que desea atacar. Ejemplo A5: ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException e) {
            System.out.println("Ocurrió un error mientras se leía la línea. Intentelo de nuevo");
        }
        return "";
    }
}
