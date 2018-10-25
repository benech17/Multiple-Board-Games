public class DominoesPlayer extends Player {

    public boolean isYounger(Player p) {
        return getAge() < p.getAge();
    }

}
