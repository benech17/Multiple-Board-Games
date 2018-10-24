public class JoueurDomino extends Joueur {

    public boolean estPlusJeune(Joueur j) {
        return getAge() < j.getAge();
    }

}
