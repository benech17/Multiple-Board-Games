package model.core.player;

public interface Player {

    String getName();

    int getAge();

    /**
     *
     * @param p
     * @return true if the current player is younger than the player p
     */
    boolean isYoungerThan(Player p);

    /**
     *
     * @param p
     * @return true if the name of the current player comes before the other
     * player's name p in the lexicographical order
     */
    boolean nameComesFirst(Player p);

    /**
     * Play his turn
     */
    void takeTurn();
}
