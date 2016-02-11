
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
        
        if (!model.joueurs[model.getTour()].isHuman()){
            model.joueurs[model.getTour()].jouerCoup();
            vue.repaint();
            try{
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }


            //test de placement
            int unBpPlus = model.joueurs[model.getTour()].jouerCoupPlateau(vue.bPlus.size());
            if (model.plateau.compareDate(model.select, unBpPlus)){ // coup valide
                vue.labelDate.setText("coup possible, Nom : "+model.select.getNom()+", Date : " + model.select.getDate());
                vue.labelDate.setForeground(Color.GREEN);

                model.select.setBorder(null);
                model.plateau.ajouterCarte(model.select,unBpPlus);
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
                vue.bPlus.add(unBpPlus, jb);

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
                vue.labelDate.setText("coup impossible, Nom : "+model.select.getNom()+", Date : " + model.select.getDate());
                vue.labelDate.setForeground(Color.RED);

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
            vue.joueurGagne();
            model.tourSuivant();
            vue.joueurSuivant();

        }else { // vrai joueur
        
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
