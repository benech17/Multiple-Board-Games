package games.saboteur;

import games.core.model.card.Card;
import org.junit.Test;

import java.util.Queue;

import static org.junit.Assert.*;

public class SaboteurDeckBuilderImplTest {

    @Test
    public void buildPathCards() {
        SaboteurDeckBuilderImpl deckBuilder = new SaboteurDeckBuilderImpl();
        Queue<Card> deck = deckBuilder.build();
        System.out.println(deck);
        System.out.println(deck.size());
    }
}