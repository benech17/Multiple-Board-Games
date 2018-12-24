package games.core.model.player;

import games.core.model.board.Coordinate;
import games.core.model.hand.Hand;
import games.core.model.hand.HandImpl;


/**
 * Should we keep generics here?
 *
 * @param <B>
 * @param <C>
 */
public abstract class PlayerImpl<B, C> implements Player<B> {
    protected String name;
    protected int age;
    protected Hand<C> hand;

    public PlayerImpl(String name, int age) {
        this.name = name;
        this.age = age;
        hand = new HandImpl<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean isYoungerThan(Player p) {
        return age < p.getAge();
    }

    @Override
    public void takeTurn(B b, int handIndex, Coordinate c) {
        // Abstract or not?
        // May add something if we find some common pattern in the games

    }

    @Override
    public boolean nameComesFirst(Player p) {
        return name.compareTo(p.getName()) < 0;
    }
}
