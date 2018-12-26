package games.saboteur.cards.actioncard;


public class BlockCard extends ActionCard {

    public BlockCard(ActionCardType type) {
        super(type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BlockCard that = (BlockCard) obj;
        return type.equals(that.type);
    }

    @Override
    public String toString() {
        return "Block card of type " + type;
    }
}
