package games.core.model.hand;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO: finish hand implementation
 *
 * @param <C>
 */
public class HandImpl<C> implements Hand<C> {
    List<C> hand;

    public HandImpl() {
        hand = new ArrayList<>();
    }

    @Override
    public void addCard(C card) {
        hand.add(card);
    }

    @Override
    public C drawCard(int index) {
        return null;
    }

    @Override
    public boolean discardCard(int index) throws IndexOutOfBoundsException {
        return false;
    }
}
