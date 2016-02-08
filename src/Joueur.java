import java.util.ArrayList;

public class Joueur {
    private String nom;
    private ArrayList<Carte> main;
    private Pioche pioche;
    
    public Joueur(String nom, Pioche pioche){
        this.nom = nom;
        this.pioche = pioche;
        main = new ArrayList<Carte>();
        for (int i = 0; i < 6; i++) {
            piocher();
        }
    }
    
    public void piocher(){
        if(main.size()>6){
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

    public ArrayList<Carte> getMain(){ return main; }

    public boolean enleverCarte(Carte crt){
        return main.remove(crt);
    }

    public boolean isHuman(){return true;}
}
