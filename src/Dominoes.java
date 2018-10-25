public class Dominoes extends Game {
    private DominoesBoard board;

    public Dominoes(DominoesBoard board) {
        this.board = board;
    }

    public void addFirst(DominoTile d) {
        board.getArray().add(0, d);
    }

    public void addLast(DominoTile d) {
        board.getArray().add(board.getArray().size() - 1, d);
    }

    @Override
    public void play() {
        return;
    }
}
