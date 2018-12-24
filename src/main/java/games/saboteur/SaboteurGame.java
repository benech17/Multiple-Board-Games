package games.saboteur;

import games.core.model.card.Card;
import games.core.model.deck.Deck;
import games.core.model.deck.DeckImpl;


public class SaboteurGame {
    private SaboteurBoard board;
    private SaboteurPlayer[] players;
    private Deck<Card> deck;
    private SaboteurDeckBuilder deckBuilder;

    public SaboteurGame(int nbPlayers) throws InvalidNumberOfPlayersException {
        if (nbPlayers <= 1)
            throw new InvalidNumberOfPlayersException();
        this.board = new SaboteurBoard();
        this.players = new SaboteurPlayer[nbPlayers];
        deckBuilder = new SaboteurDeckBuilderImpl();
        this.deck = new DeckImpl<>(deckBuilder);
    }

    public void play() {
        boolean gameEnds = false;
        while (!gameEnds) {
            for (int i = 0; i < players.length; i++) {
                //players[i].takeTurn(board, );
            }
        }

    }
}
