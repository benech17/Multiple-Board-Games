package games.core.model.player;

import games.core.model.hand.Hand;


public abstract class PlayerImpl<C> implements Player {
    protected String name;
    protected int age;
    protected Hand<C> hand;

    public PlayerImpl(String name, int age) {
        this.name = name;
        this.age = age;
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
    public boolean nameComesFirst(Player p) {
        return name.compareTo(p.getName()) < 0;
    }
}
