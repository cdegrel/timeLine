import java.util.Scanner;

public class Plateau {

    private int nbJoueurs;
    private int tourJoueur;
    private Pioche pioche;
    private CartesPlateau cartesPlateau;

    public Plateau() {
        pioche = new Pioche();
        cartesPlateau = new CartesPlateau();
        tourJoueur = 1;

        Scanner sc = new Scanner (System.in);
        //System.out.println("Combien de joueurs ?? ");
        //nbJoueurs = sc.nextInt();
    }

    public boolean verifierChronologie() {
        return cartesPlateau.verifierChronologie();
    }

    public void ajouterUneCarte(Carte carte) {
        pioche.ajouterUneCarte(carte);
    }

    public void setNbJoueurs(int nbJoueurs) { this.nbJoueurs = nbJoueurs; }

    public void setTourJoueur(int tourJoueur) { this.tourJoueur = tourJoueur; }

    public int getTourJoueur() { return tourJoueur; }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void selectionnerJoueur() {
        if (tourJoueur < nbJoueurs) {
            tourJoueur++;
        }else{
            tourJoueur = 1;
        }
    }
}
