import javax.swing.*;
import java.awt.*;

public class Carte extends JPanel{
    private String nom;
    private int date;
    private boolean retourner;

    Toolkit tk = Toolkit.getDefaultToolkit();
    protected Image image, imadate;
    
    public Carte(String nom, int date){
        this.nom=nom;
        image = new ImageIcon("Images/Image/" + nom + ".jpg").getImage();
        imadate = new ImageIcon("Images/Date/"+nom+date+".jpg").getImage();

        this.date=date;
        retourner=false;
        setSize(new Dimension(160,245));
        setMaximumSize(new Dimension(160,245));
        setMinimumSize(new Dimension(160,245));
        setPreferredSize(new Dimension(160,245));
        setBackground(new Color(100,100,100)); //pour les voir quand l'image marche pas...
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

    public void retourner(){retourner = true;}
    
    public boolean getRetourner(){
        return retourner;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString(nom,10,10);
        if(retourner){
            g.drawImage(imadate,0,0,160,245,null);
        }else{
            g.drawImage(image,0,0,160,245,null);
        }

    }
}
