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
        for (int i = 0; i < vue.bChoix.length; i++) {
            if (e.getSource() == vue.bChoix[i]){
                model.setNbJoueur(i+2);
                vue.nouvellePartie();
            }
        }
    }
}
