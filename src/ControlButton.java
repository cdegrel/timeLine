import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlButton implements ActionListener{
    protected Model model;
    protected Vue vue;

    public ControlButton(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;

        vue.setControlButton(this);
    }

    public void actionPerformed(ActionEvent e){

        int nbOrdi = 0;
        try {
            nbOrdi = Integer.parseInt(vue.activerIA.getText());
        }catch (Exception ex){
            JOptionPane.showMessageDialog(vue, "Entrez un nombre valide entre 0 et 6",
                    "avertissement",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (nbOrdi > 5 || nbOrdi < 0){
            JOptionPane.showMessageDialog(vue, "Il ne peut y avoir qu'entre 0 et 5 joueurs ordinateurs",
                    "avertissement",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }


        model.file="Images/"+vue.choixPaquet.getSelectedItem();


        model.initAttrib();

        for (int i = 0; i < vue.bChoix.length; i++) {
            if (e.getSource() == vue.bChoix[i]){
                if (i+1+nbOrdi > 6 || i+1+nbOrdi<2){
                    JOptionPane.showMessageDialog(vue, "Il ne peut y avoir qu'entre 2 et 6 joueurs",
                            "avertissement",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                model.setNbJoueur(i+1, nbOrdi);
                model.initPioche();
                model.initJoueurs();
                vue.nouvellePartie();
            }
        }
    }
}
