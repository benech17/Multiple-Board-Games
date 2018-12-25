package games.saboteur;

import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.actioncard.ActionCardType;
import games.saboteur.cards.actioncard.BlockCard;
import games.saboteur.cards.actioncard.RepairCard;
import games.saboteur.cards.pathcard.PathCard;
import games.saboteur.cards.pathcard.SaboteurTile;

import java.util.Stack;

public class SaboteurDeckBuilderImpl implements SaboteurDeckBuilder {
    private Stack<SaboteurCard> deck;

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

    /**
     * Four copies of each action card
     */
    @Override
    public void buildActionCards() {
        for (ActionCardType type : ActionCardType.values()) {
            for (int i = 0; i < 4; i++) {
                deck.add(new BlockCard(type));
                deck.add(new RepairCard(type));
            }
        }
    }

    @Override
    public Stack<SaboteurCard> build() {
        buildPathCards();
        buildActionCards();
        return deck;
    }
}
