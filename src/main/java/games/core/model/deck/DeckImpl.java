package games.core.model.deck;

import games.core.model.hand.Hand;

import java.util.Collections;
import java.util.Stack;


public class DeckImpl<C> implements Deck<C> {
    protected Stack<C> cards;

    public DeckImpl(DeckBuilder<C> deckBuilder) {
        this.cards = deckBuilder.build();
    }

    public Stack<C> getCards() {
        return cards;
    }

    public void setCards(Stack<C> cards) {
        this.cards = cards;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public void deal(Hand<C> hand) throws EmptyDeckException {
        if (cards.isEmpty())
            throw new EmptyDeckException();
        C c = cards.pop();
        hand.addCard(c);
    }

    @Override
    public void distributeCards() {

    }

    @Override
    public void addCard(C card) {
        cards.add(card);
    }
}
