import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Kiéran on 08/02/2016.
 */
public class Ordi extends Joueur{
    public Model model;
    
    Random rand = new Random();

    public Ordi(String nom, Pioche pioche) {
        super(nom,pioche);
    }
    public Ordi(String nom, Pioche pioche, Model model) {
        super(nom,pioche);
        this.model = model;
    }

    public boolean isHuman(){return false;}

    public int jouerCoup(){
        // que fait l'ordi?

        //choisi une carte qui est dans son paquet
        int indexCarte = rand.nextInt(tailleMain());
        Carte carte = getCarte(indexCarte);
        System.out.println( getNom()+" à choisi la carte "+carte.getNom());
        //la met en rouge
        if (!carte.getRetourner()){
            model.select = carte;
            model.select.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.RED));
        }
        return indexCarte;
    }
    
    public int jouerCoupPlateau(int nbBpPlus){
        return rand.nextInt(nbBpPlus);
    }
}
