package games.common.model.deck;

import games.common.model.hand.Hand;

import java.util.Collections;
import java.util.List;
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
    public void distributeCards(List<? extends Hand<C>> hands) throws EmptyDeckException {
        for (int i = 0; i < hands.get(0).getCardNumberAtStart(); i++) {
            for (Hand<C> hand : hands)
                deal(hand);
        }
    }

    @Override
    public void addCard(C card) {
        cards.add(card);
    }
}
