package games.saboteur.cards.actioncard;

/**
 * Different type of actions
 */
public enum ActionCardType {
    TRANSPORT(0), LIGHTING(1), TOOLS(2);

    private int index;

    ActionCardType(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }
}
