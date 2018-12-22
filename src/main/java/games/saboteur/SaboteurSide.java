package games.saboteur;

import games.core.model.card.tile.Side;

import java.util.Objects;

public class SaboteurSide extends Side {
    private boolean hasPath;

    public SaboteurSide(SaboteurTile parent, boolean hasPath) {
        super(parent, null);
        this.hasPath = hasPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaboteurSide that = (SaboteurSide) o;
        return hasPath == that.hasPath;
    }

    public void setHasPath(boolean hasPath) {
        this.hasPath = hasPath;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasPath);
    }

    @Override
    public String toString() {
        return "SaboteurSide{" + hasPath + "}";
    }
}
