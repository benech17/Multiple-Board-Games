package model.core.card.side;

public abstract class Side implements Cloneable {

    @Override
    protected Side clone() throws CloneNotSupportedException {
        return (Side) super.clone();
    }
}
