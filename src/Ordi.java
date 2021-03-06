import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Kiéran on 08/02/2016.
 */
public class Ordi extends Joueur{

    // memoire commune a tous les ordis
    private static HashMap<String,Integer> memoireDate = new HashMap<String, Integer>();

    public Model model;
    private int dateApprox = 0;

    Random rand = new Random();

    public Ordi(String nom, Pioche pioche) {
        super(nom,pioche);
    }
    public Ordi(String nom, Pioche pioche, Model model) {
        super(nom,pioche);
        this.model = model;
    }

    public boolean isHuman(){return false;}

    public int jouerCoup() {
        // que fait l'ordi?

        //choisi une carte qui est dans son paquet
        int indexCarte = rand.nextInt(tailleMain());
        Carte carte = getCarte(indexCarte);

        if (memoireDate.containsKey(carte.getNom())) {
            //s'il s'en souvient
            dateApprox = memoireDate.get(carte.getNom());
            System.out.println( getNom()+" à choisi la carte "+carte.getNom()+" date souvenue : "+dateApprox);
        } else {
            // sinon prend une date a 100 ans pres
            dateApprox = carte.getDate() + (100 - rand.nextInt(200));
            System.out.println( getNom()+" à choisi la carte "+carte.getNom()+" date approximative : "+dateApprox);

            if(rand.nextBoolean()){
                // 1/2 chances qu'il se souvienne de la vraie date
                memoireDate.put(carte.getNom(),carte.getDate());
            }
        }
        //la met en rouge
        if (!carte.getRetourner()){
            model.select = carte;
            model.select.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.RED));
        }
        return indexCarte;
    }

    public int jouerCoupPlateau(int nbBpPlus){
        int index = 0;
        for (Carte crt : model.plateau.getPlateau()){
            if(crt.getDate() < dateApprox) index++;
        }
        return index;
    }
}
