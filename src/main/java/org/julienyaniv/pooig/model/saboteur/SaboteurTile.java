package org.julienyaniv.pooig.model.saboteur;

import org.julienyaniv.pooig.model.core.card.tile.AbstractTile;
import org.julienyaniv.pooig.model.core.enums.Direction;


/**
 * TODO: Implement Iterable? in the abstract class AbstractTile?
 */
public abstract class SaboteurTile extends AbstractTile<SaboteurSide> {
    private boolean hasPath;

    public SaboteurTile(boolean hasPath) {
        this.hasPath = hasPath;
    }

    /**
     * TODO
     *
     * @param t
     * @param d
     * @return
     */
    public boolean sidesMatch(SaboteurTile t, Direction d) {
        return true;
    }

    public boolean treasureReached() {
        return findGoal(node -> (node instanceof TreasureCard));
    }

    public boolean isHasPath() {
        return hasPath;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
