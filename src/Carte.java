public class Carte {
    private String nom, photo;
    private int date;
    private boolean retourner;
    
    public Carte(String nom, String photo, int date){
        this.nom=nom;
        this.photo=photo;
        this.date=date;
        retourner=false;
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getPhoto(){
        return photo;
    }
    
    public int getDate(){
        return date;
    }
    
    public boolean getRetourner(){
        return retourner;
    }
    
    
}
