package games.core.model.hand;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO: finish hand implementation
 *
 * @param <C>
 */
public abstract class HandImpl<C> implements Hand<C> {
    protected List<C> hand;

    public HandImpl() {
        hand = new ArrayList<>();
    }

    @Override
    public List<C> getHand() {
        return hand;
    }

    @Override
    public void addCard(C card) {
        hand.add(card);
    }

    public C getCardAt(int index) {
        return hand.get(index);
    }

    @Override
    public C drawCard(int index) {
        C draw = hand.get(index);
        hand.remove(index);
        return draw;
    }
}
