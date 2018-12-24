package games.saboteur.cards.actioncard;


public class RepairCard extends ActionCard {
    private int index;

    public RepairCard(ActionCardType type) {
        super("Repair card of type " + type.toString().toLowerCase(), false);
        index = type.getIndex();
    }

    public int getIndex() {
        return index;
    }
}
