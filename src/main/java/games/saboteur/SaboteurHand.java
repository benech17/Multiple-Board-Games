package games.saboteur;

import games.common.model.hand.HandImpl;
import games.saboteur.cards.SaboteurCard;

public class SaboteurHand extends HandImpl<SaboteurCard> {
    @Override
    public int getCardNumberAtStart() {
        return 5;
    }
}
