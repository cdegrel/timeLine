import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    private int nbJoueur;
    public Pioche pioche;


    public Model(){
        initPioche();
    }

    public int getNbJoueur(){ return nbJoueur; }

    public void setNbJoueur(int nbJoueur){ this.nbJoueur = nbJoueur; }

    public String readRegle() {
        return "";
    }

    public void initPioche(){
        pioche.vider();
        List<Carte> listCarte = new ArrayList<Carte>();

        listCarte.add(new Carte("1HommeDansLespace", 1961));
        listCarte.add(new Carte("baguetteDePain", 1830));
        listCarte.add(new Carte("bandeDessinee", 1826));
        listCarte.add(new Carte("cadranSolaire", -1500));
        listCarte.add(new Carte("calligraphieChinoise", -1200));
        listCarte.add(new Carte("cartesAJouer", 900));
        listCarte.add(new Carte("cendrillon", 1697));
        listCarte.add(new Carte("echecs", 570));
        listCarte.add(new Carte("ferARepasserElectrique", 1882));
        listCarte.add(new Carte("feuxDeSignalisation",1868));
        listCarte.add(new Carte("football", 1863));
        listCarte.add(new Carte("lunettesDeSoleil", 1929));
        listCarte.add(new Carte("marteauPiqueur",1861));
        listCarte.add(new Carte("navetteSpaciale", 1981));
        listCarte.add(new Carte("pierreDeRosette", -196));
        listCarte.add(new Carte("robinDesBois", 1377));
        listCarte.add(new Carte("sandwich", 1762));
        listCarte.add(new Carte("secheCheveux", 1890));
        listCarte.add(new Carte("soucoupeVolante", 1947));


        Collections.shuffle(listCarte);
        for (Carte carte : listCarte) {
            pioche.ajouterUneCarte(carte);
        }
    }
}
