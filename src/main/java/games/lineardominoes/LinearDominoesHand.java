package games.lineardominoes;

import games.common.model.hand.HandImpl;

public class LinearDominoesHand extends HandImpl<LinearDominoTile> {
    @Override
    public int getCardNumberAtStart() {
        return 5;
    }
}
