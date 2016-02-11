import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Model {
    private int nbJoueur;
    public Pioche pioche;
    public Joueur[] joueurs;
    public int tour;
    public ImageIcon regles;

    public Carte select;
    
    public String file = "";

    public CartesPlateau plateau;

    public Model(){
        plateau = new CartesPlateau();
        pioche = new Pioche();
        regles = new ImageIcon("Images/regles.png");
        tour = 0;

    }

    public void initAttrib(){
        initPioche();
        plateau.viderPlateau();
        plateau.ajouterCarte(pioche.tirerUneCarte());

        plateau.retournerPlateau();

        initJoueurs();
    }

    public int getNbJoueur(){ return nbJoueur; }

    public void setNbJoueur(int nbJoueur){ this.nbJoueur = nbJoueur; }

    public void tourSuivant(){
        tour++;
        if (tour>=nbJoueur) tour = 0;
    }

    public ImageIcon getRegle() {
        return regles;
    }

    public void initJoueurs(){
        joueurs = new Joueur[nbJoueur];
        for (int i = 0; i < nbJoueur; i++){
            //fait de joueurs humain
            //joueurs[i] = new Joueur("joueur "+(i+1), pioche);
            //fait des joueurs ordis
            joueurs[i] = new Ordi("ordi"+(i+1), pioche, this);
        }
    }

    public void initPioche(){
        pioche.vider();
        List<Carte> listCarte = new ArrayList<Carte>();

        try {
            listCarte = loadCarte(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.shuffle(listCarte);
        for (Carte carte : listCarte) {
            pioche.ajouterUneCarte(carte);
        }
    }

    public int testJoueurGagne(){
        for(int i=0; i<nbJoueur; i++){
            if (joueurs[i].getMain().size() == 0){
                return i;
            }
        }
        return -1;
    }
    
    public List<Carte> loadCarte(String fileName) throws IOException {
        BufferedReader br;
        char[] tab = new char[2];
        int nbLu;
        Carte carte;
        List<Carte> listCarte = new ArrayList<Carte>();

        br = new BufferedReader(new FileReader(fileName));
        nbLu = br.read(tab,0,2);
        while (nbLu > 0) {
            if (nbLu != 2) throw new IOException("file corrupted");

            String line = br.readLine();
            String[] tab2 = line.split(",");
            carte = new Carte(tab2[0], Integer.parseInt(tab2[1]));

            listCarte.add(carte);
            nbLu = br.read(tab,0,2);
        }
        return listCarte;
    }
    
    public int getTour(){return tour;}
}
