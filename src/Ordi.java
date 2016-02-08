/**
 * Created by Kiéran on 08/02/2016.
 */
public class Ordi extends Joueur{

    public Ordi(String nom, Pioche pioche) {
        super(nom,pioche);
    }

    public boolean isHuman(){return false;}

    public void jouerCoup(){
        // que fait l'ordi?
    }
}
