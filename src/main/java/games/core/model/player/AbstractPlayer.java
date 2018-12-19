package games.core.model.player;

public abstract class AbstractPlayer implements Player {
    private String name;
    private int age;

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
