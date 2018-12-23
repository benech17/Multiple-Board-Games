package games.saboteur;

import games.core.model.card.Card;
import org.junit.Test;

import java.util.Stack;

public class SaboteurDeckBuilderImplTest {

    @Test
    public void buildPathCards() {
        SaboteurDeckBuilderImpl deckBuilder = new SaboteurDeckBuilderImpl();
        Stack<Card> deck = deckBuilder.build();
        System.out.println(deck);
        System.out.println(deck.size());
    }
}