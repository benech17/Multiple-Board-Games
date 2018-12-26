package games.saboteur.cards.actioncard;

import games.saboteur.cards.SaboteurCard;

public abstract class ActionCard implements SaboteurCard {
    protected final ActionCardType type;

    public ActionCard(ActionCardType type) {
        this.type = type;
    }

    public ActionCardType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
