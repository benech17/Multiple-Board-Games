package games.saboteur;

import games.core.model.card.Card;

public abstract class ActionCard extends Card {

    public ActionCard(String name, boolean hidden) {
        super(name, hidden);
    }
}