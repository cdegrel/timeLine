public class Model {
    private final int NB_MAX_JOUEUR = 4;

    private int nbJoueur;


    public Model(){

    }

    public int getNB_MAX_JOUEUR(){ return NB_MAX_JOUEUR; }

    public int getNbJoueur(){ return nbJoueur; }

    public void setNbJoueur(int nbJoueur){ this.nbJoueur = nbJoueur; }

    public String readRegle() {
        return "";
    }
}
