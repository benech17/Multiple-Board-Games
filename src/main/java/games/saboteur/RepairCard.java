package games.saboteur;

public class RepairCard extends ActionCard {
    private int index;

    public RepairCard(ActionCardType type) {
        super(type.toString(), false);
        index = type.getIndex();
    }

    public int getIndex() {
        return index;
    }
}
