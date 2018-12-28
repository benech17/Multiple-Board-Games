package games.saboteur.cards.pathcard;


public class TreasureCard extends GoalCard {
    private static final int AMOUNT_POINTS = 100;

    public TreasureCard() {
        name = "Treasure Card" + name;
    }

    public int getAmountPoints() {
        if (isHidden())
            throw new PathCardException.CantRevealHiddenCardException();
        return AMOUNT_POINTS;
    }
}
