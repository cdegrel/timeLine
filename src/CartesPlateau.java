import java.util.ArrayList;
import java.util.List;

public class CartesPlateau {

    private ArrayList<Carte> tas;

    public CartesPlateau() {
        tas = new ArrayList<Carte>();
    }

    public Carte getCarte(int index) {
        return tas.get(index);
    }

    public boolean compareDate(Carte carte, int index) {
        Carte cartePrev = tas.get(index);
        Carte carteNext = tas .get(index);
        if ((cartePrev.getDate() < carte.getDate()) && (carte.getDate() < carteNext.getDate()) ) {
            return true;
        } else {
            return false;
        }
    }

    public void ajouterCarte(Carte carte, int index){
        tas.add(index, carte);
    }

    public void ajouterCarte(Carte carte){
        tas.add(carte);
    }

    public boolean verifierChronologie() {
        int compare = 0;
        Carte carte;
        for (int i = 0; i < tas.size(); i++) {
            carte = tas.get(i);
            if (carte.getDate() >= compare) {
                compare = carte.getDate();
            } else {
                return false;
            }
        }
        return true;
    }

    public List<Carte> getPlateau() {
        return tas;
    }
}
