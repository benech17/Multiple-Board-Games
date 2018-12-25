package games.saboteur.cards.actioncard;

import games.saboteur.cards.SaboteurCard;

public abstract class ActionCard implements SaboteurCard {
    private String name;
    private boolean hidden;

    public ActionCard(String name, boolean hidden) {
        this.name = name;
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return name;
    }
}
