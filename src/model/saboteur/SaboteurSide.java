package model.saboteur;

import model.core.card.side.Side;

public class SaboteurSide extends Side {
    // True if the side is connected with the other sides of the parent tile
    private boolean pathConnexion;
    private boolean connected;

    public SaboteurSide(boolean connected, SaboteurTile parent) {
        super(parent, null);
        this.connected = connected;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
