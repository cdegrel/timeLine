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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int j = 0; j < vue.bPlus.size(); j++) {
            if (e.getSource() == vue.bPlus.get(j) && model.select != null){
                if (model.plateau.compareDate(model.select, j)){ // coup valide
                    model.select.setBorder(null);
                    model.plateau.ajouterCarte(model.select,j);
                    for (Joueur joueur : model.joueurs) {
                        if (joueur.enleverCarte(model.select)){
                        }
                    }
                    model.select = null;
                    for (Joueur joueur :model.joueurs){
                        joueur.enleverCarte(model.select);
                    }

                    JButton jb = new JButton("+");
                    vue.addActionPlus(jb);
                    vue.bPlus.add(j, jb);

                    vue.scrolplateau.removeAll();

                    for (int i = 0; i < model.plateau.getPlateau().size(); i++) {
                        vue.scrolplateau.add(vue.bPlus.get(i));
                        vue.scrolplateau.add(model.plateau.getCarte(i));
                    }
                    vue.scrolplateau.add(vue.bPlus.get(vue.bPlus.size()-1));

                    model.plateau.retournerPlateau();
                    vue.scrolplateau.revalidate();
                    vue.scrolplateau.repaint();
                    vue.tabPane.revalidate();
                    vue.tabPane.repaint();
                }else{
                    System.out.println("coup impossible, Date : "+model.select.getDate());

                    /*model.select.retourner();
                    model.select.revalidate();
                    model.select.repaint();

                    vue.reInitTabPane();
                    try {
                        Thread.sleep(2000);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    model.select.recacher();*/

                    vue.tabPane.remove(model.select);
                    for (Joueur joueur : model.joueurs) {
                        if (joueur.enleverCarte(model.select)){
                            joueur.piocher();

                        }
                    }
                    model.pioche.ajouterUneCarte(model.select);
                    model.select = null;


                    vue.reInitTabPane();

                }
                vue.joueurSuivant();
            }
        }
    }
}