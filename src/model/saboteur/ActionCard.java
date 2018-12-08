package model.saboteur;

import model.core.card.Card;

public abstract class ActionCard extends Card {

    public ActionCard(String name, boolean hidden) {
        super(name, hidden);
    }
}
