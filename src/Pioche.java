import java.util.ArrayDeque;
import java.util.Collections;

public class Pioche {

    ArrayDeque<Carte> pioche;

    public Pioche() {
        pioche = new ArrayDeque<Carte>();
    }

    public Carte tirerUneCarte() {
        return pioche.pop();
    }

    public void ajouterUneCarte(Carte carte) {
        carte.setBorder(null);
        pioche.addLast(carte);
    }

    public void vider(){
        pioche.clear();
    }
}
