package com.personal.battleship.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by karenvega on 9/30/16.
 */
public class Reader {

    BufferedReader br;

    public Reader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String read(String message) {
        System.out.println(message);
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println("Ocurrió un error mientras se leía la línea. Intentelo de nuevo");
            e.printStackTrace();
        }
        return "";
    }

    public void closeReader() throws IOException {
        br.close();
    }
}
