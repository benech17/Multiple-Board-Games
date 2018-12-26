package games.saboteur.cards.actioncard;


public class RepairCard extends ActionCard {

    public RepairCard(ActionCardType type) {
        super(type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RepairCard that = (RepairCard) obj;
        return type.equals(that.type);
    }

    @Override
    public String toString() {
        return "Repair card of type " + type;
    }
}
