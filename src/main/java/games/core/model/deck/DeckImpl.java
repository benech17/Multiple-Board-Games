package games.core.model.deck;

import games.core.model.hand.Hand;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public abstract class DeckImpl<C> implements Deck<C> {
    protected Stack<C> cards;

    public Stack<C> getCards() {
        return cards;
    }

    public void setCards(Stack<C> cards) {
        this.cards = cards;
    }

    @Override
    public void shuffle() {
        Collections.shuffle((List<?>) cards);
    }

    @Override
    public void deal(Hand hand) throws EmptyDeckException {
        if (cards.isEmpty())
            throw new EmptyDeckException();
        C c = cards.pop();
        hand.addCard(c);
    }

    @Override
    public void addCard(C card) {
        cards.add(card);
    }
}
