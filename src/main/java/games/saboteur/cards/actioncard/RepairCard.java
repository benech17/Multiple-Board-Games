package games.saboteur.cards.actioncard;


public class RepairCard extends ActionCard {
    private ActionCardType type;

    public RepairCard(ActionCardType type) {
        super("Repair card of type " + type.toString().toLowerCase(), false);
        this.type = type;
    }

    public ActionCardType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RepairCard that = (RepairCard) obj;
        return type.equals(that.type);
    }
}
