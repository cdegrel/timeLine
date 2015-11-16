import java.util.ArrayDeque;
import java.util.Collections;

public class Pioche {

    ArrayDeque<Carte> pioche;

    public Pioche() {
        pioche = new ArrayDeque<Carte>();
    }

    public Carte tirerUneCarte() {
        return pioche.getFirst();
    }

    public void ajouterUneCarte(Carte carte) {
        pioche.addLast(carte);
    }

    public void vider(){
        pioche.clear();
    }
}
