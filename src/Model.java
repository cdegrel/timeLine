import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Model {
    private int nbJoueur;
    private int nbOrdi;
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

    public int getNbJoueur(){ return nbJoueur+nbOrdi; }

    public void setNbJoueur(int nbJoueur, int nbOrdi){
        this.nbJoueur = nbJoueur;
        this.nbOrdi = nbOrdi;
    }

    public void tourSuivant(){
        tour++;
        if (tour>=nbJoueur+nbOrdi) tour = 0;
    }

    public ImageIcon getRegle() {
        return regles;
    }

    public void initJoueurs(){
        joueurs = new Joueur[nbJoueur+nbOrdi];
        for (int i = 0; i < nbJoueur; i++){
            //fait de joueurs humain
            joueurs[i] = new Joueur("joueur "+(i+1), pioche);
        }
        for (int j = nbJoueur; j < nbJoueur+nbOrdi; j++) {
            //fait des joueurs ordis
            joueurs[j] = new Ordi("ordi"+(j+1), pioche, this);
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
        for(int i=0; i<nbJoueur+nbOrdi; i++){
            if (joueurs[i].getMain().size() == 0){
                return i;
            }
        }
        return -1;
    }

    public List<String> getListPaquet(){
        File rep = new File("Images");
        String[] files = rep.list();
        List<String> list = new ArrayList<String>();
        for(String file : files){
            if (!file.contains(".") && !file.equals("Date") && !file.equals("Image")){
                list.add(file);
            }
        }

        return list;
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
