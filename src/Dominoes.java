public class Dominoes extends Game {
    private DominoesBoard board;

    public Dominoes(DominoesBoard board) {
        this.board = board;
    }

    public void addFirst(DominoTile d) {
        board.getArray().add(0, d);
    }
}
