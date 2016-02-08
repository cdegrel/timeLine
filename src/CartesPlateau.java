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
        if (index != 0) {
            Carte cartePrev = tas.get(index-1);
            if (carte.getDate()<cartePrev.getDate()) {
                return  false;
            }
        }
        if (index != tas.size()) {
            Carte carteNext = tas.get(index);
            if (carte.getDate()>carteNext.getDate()) {
                return  false;
            }
        }
        return  true;
    }

    public void ajouterCarte(Carte carte, int index){
        tas.add(index, carte);
    }

    public void ajouterCarte(Carte carte){
        tas.add(carte);
    }

    public void retournerPlateau(){
        for (Carte crt : tas){ crt.retourner(); }
    }

    public List<Carte> getPlateau() {
        return tas;
    }

    public void viderPlateau() {
        tas.clear();
    }
}
