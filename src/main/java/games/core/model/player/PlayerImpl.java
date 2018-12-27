package games.core.model.player;

import games.core.model.hand.Hand;


/**
 * Default implementation of a player
 * @param <C> the type of cards a player holds in his hand
 */
public abstract class PlayerImpl<C> implements Player {
    protected String name;
    protected int age;
    protected int score;
    protected Hand<C> hand;

    public PlayerImpl(String name, int age) {
        this.name = name;
        this.age = age;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void increaseScore(int amount) {
        score += amount;
    }

    public int getScore() {
        return score;
    }

    public Hand<C> getHand() {
        return hand;
    }

    @Override
    public boolean isYoungerThan(Player p) {
        return age < p.getAge();
    }

    /*@Override
    public void takeTurn(B b, int handIndex, Coordinate c) {
        // Abstract or not?
        // May add something if we find some common pattern in the games

    }*/

    @Override
    public boolean nameComesFirst(Player p) {
        return name.compareTo(p.getName()) < 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
