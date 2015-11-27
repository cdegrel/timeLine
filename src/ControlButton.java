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
        for (int i = 0; i < vue.bChoix.length; i++) {
            if (e.getSource() == vue.bChoix[i]){
                model.setNbJoueur(i+2);
                model.initJoueurs();
                vue.nouvellePartie();
            }
        }

        for (int j = 0; j < vue.bPlus.size(); j++) {
            if (e.getSource() == vue.bPlus.get(j) && model.select != null){
                if (true){ // coup valide
                    vue.scrolplateau.add(model.select,(j*2)+1);
                    model.select = null;
                    vue.bPlus.add((j*2)+2,new JButton("+"));
                    vue.scrolplateau.revalidate();
                    vue.scrolplateau.repaint();
                }else{
                    System.out.println("coup impossible");
                }
            }
        }
    }
}
