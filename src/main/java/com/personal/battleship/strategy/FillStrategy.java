package com.personal.battleship.strategy;

import com.personal.battleship.objects.Ship;

/**
 * Created by karenvega on 9/30/16.
 */
public interface FillStrategy {

    public boolean isAvailable(String grid[][], int x, int y, int size);

    public void putBattle(String grid[][], Ship battle, int x, int y);

}
