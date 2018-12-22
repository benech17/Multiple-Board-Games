package games.saboteur;

import games.core.model.card.Card;

import java.util.ArrayDeque;
import java.util.Queue;

public class SaboteurDeckBuilderImpl implements SaboteurDeckBuilder {
    private static final int NB_PATH_CARDS = 40;
    private Queue<Card> deck;

    public SaboteurDeckBuilderImpl() {
        this.deck = new ArrayDeque<>();
    }

    /**
     * Builds the path cards see
     * <a href="https://cf.geekdo-images.com/imagepage/img/It_XLWNPIf5rZXvY5rPrhtmeVUI=/fit-in/900x600/filters:no_upscale()/pic180040.jpg">image</a>.
     * They are 40, the additional 4 cards are the goal cards and start card
     * which are not build here but directly put in the board
     */
    @Override
    public void buildPathCards() {
        deck.add(new SaboteurTile(PathCards.ONE));
        deck.add(new SaboteurTile(PathCards.TWO));
        deck.add(new SaboteurTile(PathCards.THREE));
        deck.add(new SaboteurTile(PathCards.FOUR));
        deck.add(new SaboteurTile(PathCards.FIVE));
        deck.add(new SaboteurTile(PathCards.SIX));
        deck.add(new SaboteurTile(PathCards.SEVEN));
        deck.add(new SaboteurTile(PathCards.EIGHT));
        deck.add(new SaboteurTile(PathCards.NINE));
        for (int i = 0; i < 3; i++)
            deck.add(new SaboteurTile(PathCards.ELEVEN));
        for (int i = 0; i < 4; i++) {
            deck.add(new SaboteurTile(PathCards.THIRTEEN));
            deck.add(new SaboteurTile(PathCards.FIFTEEN));
        }
        for (int i = 0; i < 5; i++) {
            deck.add(new SaboteurTile(PathCards.TEN));
            deck.add(new SaboteurTile(PathCards.TWELVE));
            deck.add(new SaboteurTile(PathCards.FOURTEEN));
            deck.add(new SaboteurTile(PathCards.SIXTEEN));
        }
    }

    @Override
    public void buildActionCards() {

    }

    @Override
    public Queue<Card> build() {
        buildPathCards();
        return deck;
    }
}
