package games.core.model.deck;

import java.util.Collections;
import java.util.List;
import java.util.Queue;

public abstract class DeckImpl<C> implements Deck<C> {
    protected Queue<C> cards;

    public Queue<C> getCards() {
        return cards;
    }

    public void setCards(Queue<C> cards) {
        this.cards = cards;
    }

    @Override
    public void shuffle() {
        Collections.shuffle((List<?>) cards);
    }
}
