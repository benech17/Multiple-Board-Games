package games.saboteur.cards.actioncard;


public class BlockCard extends ActionCard {
    private ActionCardType type;

    public BlockCard(ActionCardType type) {
        super("Block card of type " + type.toString().toLowerCase(), false);
        this.type = type;
    }

    public ActionCardType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BlockCard that = (BlockCard) obj;
        return type.equals(that.type);
    }
}
