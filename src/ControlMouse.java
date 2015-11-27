
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Kiéran on 27/11/2015.
 */
public class ControlMouse implements MouseListener {
    protected Model model;
    protected Vue vue;

    public ControlMouse(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("carte");
        if (model.select != null){
            model.select.setBorder(null);
        }
        for (int i = 0; i < model.getNbJoueur(); i++) {
            for (int j = 0; j < model.joueurs[i].getMain().size(); j++) {
                if (e.getSource() == model.joueurs[i].getCarte(j)){
                    System.out.println("joueur "+(i+1)+" carte "+j);
                    if (!model.joueurs[i].getCarte(j).getRetourner()){
                        model.select = model.joueurs[i].getCarte(j);
                        model.select.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.RED));
                        vue.repaint();
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
