import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    private int nbJoueur;
    public Pioche pioche;
    public Joueur joueur1, joueur2, joueur3, joueur4;

    public Carte select;

    public CartesPlateau plateau;


    public Model(){
        plateau = new CartesPlateau();
        pioche = new Pioche();
        initPioche();

        //test !
        plateau.ajouterCarte(pioche.tirerUneCarte());
        plateau.ajouterCarte(pioche.tirerUneCarte());
        plateau.ajouterCarte(pioche.tirerUneCarte());
        plateau.ajouterCarte(pioche.tirerUneCarte());
        plateau.ajouterCarte(pioche.tirerUneCarte());
        plateau.ajouterCarte(pioche.tirerUneCarte());
        plateau.ajouterCarte(pioche.tirerUneCarte());
        //select = pioche.tirerUneCarte();
        plateau.retournerPlateau();

        joueur1 = new Joueur("j1",pioche);
        joueur2 = new Joueur("j2",pioche);
        joueur3 = new Joueur("j3",pioche);
        joueur4 = new Joueur("j4",pioche);
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
        listCarte.add(new Carte("45Tours", 1949));
        listCarte.add(new Carte("abeilles", -100000000));
        listCarte.add(new Carte("automobile", 1769));
        listCarte.add(new Carte("baguetteDePain", 1830));
        listCarte.add(new Carte("bandeDessinee", 1826));
        listCarte.add(new Carte("bombeAerosol", 1928));
        listCarte.add(new Carte("bouteilleEnVerre", -200));
        listCarte.add(new Carte("cadranSolaire", -1500));
        //listCarte.add(new Carte("cafeSoluble", xxxx));
        listCarte.add(new Carte("cafetiere", 1802));
        listCarte.add(new Carte("calligraphieChinoise", -1200));
        listCarte.add(new Carte("camembert", 1790));
        listCarte.add(new Carte("cartesAJouer", 900));
        listCarte.add(new Carte("cendrillon", 1697));
        listCarte.add(new Carte("chronometre", 1735));
        //listCarte.add(new Carte("clef", xxxx));
        listCarte.add(new Carte("consoleDeJeux", 1971));
        listCarte.add(new Carte("couteau", 1610));
        listCarte.add(new Carte("echecs", 570));
        listCarte.add(new Carte("fableCorbeau", 1668));
        listCarte.add(new Carte("ferARepasserElectrique", 1882));
        listCarte.add(new Carte("fermetureGlissiere", 1891));
        listCarte.add(new Carte("feuxDeSignalisation",1868));
        listCarte.add(new Carte("football", 1863));
        listCarte.add(new Carte("fourchette", 972));
        //listCarte.add(new Carte("frites", xxxx));
        //listCarte.add(new Carte("grillePain", xxxx));
        listCarte.add(new Carte("guitareElectrique", 1924));
        listCarte.add(new Carte("helicoptere", 1825));
        listCarte.add(new Carte("hydravion", 1910));
        listCarte.add(new Carte("jumelles", 1608));
        listCarte.add(new Carte("lesTroisMousquetaires", 1844));
        listCarte.add(new Carte("lunettesDeSoleil", 1929));
        listCarte.add(new Carte("marteauPiqueur",1861));
        listCarte.add(new Carte("microOndes",1946));
        listCarte.add(new Carte("monnaie", -680));
        listCarte.add(new Carte("motsCroises", 1913));
        listCarte.add(new Carte("navetteSpatiale", 1981));
        listCarte.add(new Carte("parapluie", 1705));
        listCarte.add(new Carte("pierreDeRosette", -196));
        listCarte.add(new Carte("poubelle", 1884));
        listCarte.add(new Carte("rasoirElectrique", 1911));
        listCarte.add(new Carte("reveil", 1847));
        listCarte.add(new Carte("robinDesBois", 1377));
        listCarte.add(new Carte("sandwich", 1762));
        listCarte.add(new Carte("savon", -1500));
        listCarte.add(new Carte("secheCheveux", 1890));
        listCarte.add(new Carte("sherlock", 1887));
        listCarte.add(new Carte("soucoupeVolante", 1947));
        listCarte.add(new Carte("sudoku", 1979));
        listCarte.add(new Carte("superHeros", 1938));
        listCarte.add(new Carte("verre", -2500));
        listCarte.add(new Carte("voyageDansLaLune", 1902));
        //listCarte.add(new Carte("yeti", xxxx));


        Collections.shuffle(listCarte);
        for (Carte carte : listCarte) {
            pioche.ajouterUneCarte(carte);
        }
    }
}
