package games.saboteur.cards.actioncard;


public class BlockCard extends ActionCard {
    private int index;

    public BlockCard(ActionCardType type) {
        super(type.toString(), false);
        index = type.getIndex();
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BlockCard that = (BlockCard) obj;
        return getName().equals(that.index);
    }
}
