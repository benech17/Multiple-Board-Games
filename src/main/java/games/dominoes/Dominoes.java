package games.dominoes;

import games.common.controller.GameManager;

public class Dominoes extends GameManager {
    private DominoesBoard board;

    public Dominoes(DominoesBoard board) {
        this.board = board;
    }

    public void addFirst(DominoTile d) {
        //board.getTiles().add(0, d);
    }

    public void addLast(DominoTile d) {
        //board.getTiles().add(board.getTiles().size() - 1, d);
    }

    @Override
    public void play() {
    }
}
