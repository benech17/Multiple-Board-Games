package games.saboteur;

import games.saboteur.cards.SaboteurCard;
import org.junit.Test;

import java.util.Stack;

public class SaboteurDeckBuilderImplTest {

    @Test
    public void buildPathCards() {
        SaboteurDeckBuilderImpl deckBuilder = new SaboteurDeckBuilderImpl();
        Stack<SaboteurCard> deck = deckBuilder.build();
        System.out.println(deck);
        System.out.println(deck.size());
    }
}