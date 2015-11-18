import java.awt.*;

public class Carte {
    private String nom;
    private int date;
    private boolean retourner;

    Toolkit tk = Toolkit.getDefaultToolkit();
    private Image image, imadate;
    
    public Carte(String nom, int date){
        this.nom=nom;
        image= tk.getImage("Image/Image/" + nom + ".jpg");
        imadate= tk.getImage("Image/Date/"+nom+date+".jpg");
        this.date=date;
        retourner=false;
    }
    
    public String getNom(){
        return nom;
    }
    
    public Image getImageCarte(){
        if (retourner){
            return imadate;
        }else {
            return image;
        }
    }
    
    public int getDate(){
        return date;
    }
    
    public boolean getRetourner(){
        return retourner;
    }
    
    /*public void afficherCarte(){
        System.out.println("nom : "+this.getNom()+" photo : "+this.getPhoto());
    }
    
    public void afficherCarteRetourner(){
        System.out.println("nom : "+this.getNom()+" photo : "+this.getPhoto()+" date : "+this.getDate());
    }*/
}
