import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu implements ActionListener {
    protected Vue vue;
    protected Model model;

    public ControlMenu(Vue vue, Model model){
        this.vue = vue;
        this.model = model;

        vue.setControlMenu(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vue.nouveau)
            nouvellePartie();

        if(e.getSource() == vue.regle)
            afficherRegle();
    }

    private void nouvellePartie(){
        vue.undisplay();
        model = new Model();
        vue = new Vue(model);
        vue.setControlButton(new ControlButton(model, vue));
        vue.setControlMenu(new ControlMenu(vue, model));
        vue.nouveau.removeActionListener(vue.nouveau.getActionListeners()[0]);
        vue.regle.removeActionListener(vue.regle.getActionListeners()[0]);
        vue.display();
    }

    private void afficherRegle(){
        JOptionPane.showMessageDialog(vue, "Regle du jeu :\n"+model.readRegle());
    }
}
