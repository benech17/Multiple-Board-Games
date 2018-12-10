package org.julienyaniv.pooig.model;

import org.julienyaniv.pooig.model.dominoes.DominoTile;

public class Test {
    public static void main(String[] args) {
        DominoTile dominoTile = null;

        try {
            dominoTile = new DominoTile(1 , 8);
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }
}
