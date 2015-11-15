import java.util.ArrayList;

public class Joueur {
    private String nom;
    private ArrayList<Carte> main;
    
    public Joueur(String nom){
        this.nom = nom;
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
        if(main>5){
            return null;
        }
        main.add(tirerUneCarte());
    }
    
    public Carte getCarte(int index){
        if(index<0 || index>main.size()){
            return null;
        }
        return main.get(index);
    }
    
    public void enleverCarte(int index){
        if(index<0 || index>main.size()){
            return null;
        }
        return main.remove(index);
    }
    
    public boolean verifMainVide(){
        return main.isEmpty();
    }
}
