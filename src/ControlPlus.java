import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kiéran on 27/11/2015.
 */
public class ControlPlus implements ActionListener{
    public Model model;
    public Vue vue;

    public ControlPlus(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;

        //vue.setControlButton(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int j = 0; j < vue.bPlus.size(); j++) {
            if (e.getSource() == vue.bPlus.get(j) && model.select != null){
                if (true){ // coup valide
                    System.out.println(j);
                    vue.scrolplateau.add(model.select, (j * 2) + 1);
                    model.select = null;
                    JButton jb = new JButton("+");
                    vue.addActionPlus(jb);
                    vue.bPlus.add(j, jb);
                    vue.scrolplateau.add(jb);
                    vue.scrolplateau.revalidate();
                    vue.scrolplateau.repaint();
                }else{
                    System.out.println("coup impossible");
                }
            }
        }
    }
}
