package games.saboteur;

import games.core.model.card.Card;

import java.util.Stack;

public class SaboteurDeckBuilderImpl implements SaboteurDeckBuilder {
    private static final int NB_PATH_CARDS = 40;
    private Stack<Card> deck;

    public SaboteurDeckBuilderImpl() {
        this.deck = new Stack<>();
    }

    /**
     * Builds the path cards see
     * <a href="https://cf.geekdo-images.com/imagepage/img/It_XLWNPIf5rZXvY5rPrhtmeVUI=/fit-in/900x600/filters:no_upscale()/pic180040.jpg">image</a>.
     * They are 40, the additional 4 cards are the goal cards and start card
     * which are not build here but directly put in the board
     */
    @Override
    public void buildPathCards() {
        deck.add(new SaboteurTile(PathCard.ONE));
        deck.add(new SaboteurTile(PathCard.TWO));
        deck.add(new SaboteurTile(PathCard.THREE));
        deck.add(new SaboteurTile(PathCard.FOUR));
        deck.add(new SaboteurTile(PathCard.FIVE));
        deck.add(new SaboteurTile(PathCard.SIX));
        deck.add(new SaboteurTile(PathCard.SEVEN));
        deck.add(new SaboteurTile(PathCard.EIGHT));
        deck.add(new SaboteurTile(PathCard.NINE));
        for (int i = 0; i < 3; i++)
            deck.add(new SaboteurTile(PathCard.ELEVEN));
        for (int i = 0; i < 4; i++) {
            deck.add(new SaboteurTile(PathCard.THIRTEEN));
            deck.add(new SaboteurTile(PathCard.FIFTEEN));
        }
        for (int i = 0; i < 5; i++) {
            deck.add(new SaboteurTile(PathCard.TEN));
            deck.add(new SaboteurTile(PathCard.TWELVE));
            deck.add(new SaboteurTile(PathCard.FOURTEEN));
            deck.add(new SaboteurTile(PathCard.SIXTEEN));
        }
    }

    @Override
    public void buildActionCards() {

    }

    @Override
    public Stack<Card> build() {
        buildPathCards();
        return deck;
    }
}
