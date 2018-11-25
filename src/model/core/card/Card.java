package model.core.card;


public abstract class Card {
    private String name;
    private boolean hidden;

    public Card(String name, boolean hidden) {
        this.name = name;
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
