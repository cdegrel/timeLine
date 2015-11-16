import java.util.ArrayList;

public class Joueur {
    private String nom;
    private ArrayList<Carte> main;
    private Pioche pioche;
    
    public Joueur(String nom, Pioche pioche){
        this.nom = nom;
        this.pioche = pioche;
        main = new ArrayList<Carte>();
    }
    
    public void afficherMain(){
        for(Carte c : main){
            c.afficherCarte();
        }
    }
    
    public String getNom(){
        return nom;
    }
    
    public Carte jouerCarte(int index){
        return getCarte(index);
    }
    
    public void piocher(){
        if(main.size()>5){
            return;
        }
        main.add(pioche.tirerUneCarte());
    }
    
    public Carte getCarte(int index){
        if(index<0 || index>main.size()){
            return null;
        }
        return main.get(index);
    }
    
    public Carte enleverCarte(int index){
        if(index<0 || index>main.size()){
            return null;
        }
        return main.remove(index);
    }
    
    public boolean verifMainVide(){
        return main.isEmpty();
    }
}
