import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vue extends JFrame{
    protected Model model;

    protected JMenuItem nouveau, regle;
    protected JButton bChoix[];

    private JPanel pMenu;

    public Vue(Model model) {
        this.model = model;

        initIntro();
        creerIntro();
        creerMenu();

        setTitle("TimeLine");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initIntro() {
        pMenu = new JPanel();
        pMenu.setLayout(new BoxLayout(pMenu, BoxLayout.Y_AXIS));

        JLabel lChoixJoueur = new JLabel("Choix du nombre de joueur");
        pMenu.add(lChoixJoueur);

        bChoix = new JButton[3];
        for (int i = 0; i < bChoix.length; i++) {
            bChoix[i] = new JButton((i+2)+" joueurs");
            pMenu.add(bChoix[i]);
        }
    }

    public void creerIntro() {
        JPanel englobe = new JPanel();
        englobe.setLayout(new BorderLayout());
        englobe.add(pMenu, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(englobe);
        setContentPane(panel);
    }

    public void initAttribut(int n){

    }

    public void creerWidget(int n){
        JPanel pTest = new JPanel();
        JLabel test = new JLabel(model.getNbJoueur()+" ");

        pTest.add(test);
        setContentPane(pTest);
    }

    public void creerMenu(){
        JMenuBar menu = new JMenuBar();
        JMenu options = new JMenu("Options");
        options.add(nouveau = new JMenuItem("Nouvelle partie"));
        options.addSeparator();
        options.add(regle = new JMenuItem("Regle du jeu"));
        menu.add(options);
        setJMenuBar(menu);
    }

    public void display(){setVisible(true);}
    public void undisplay(){setVisible(false);}


    public void setControlButton(ActionListener listener) {
        for(JButton b : bChoix){
            b.addActionListener(listener);
        }
    }

    public void setControlMenu(ActionListener listener) {
        nouveau.addActionListener(listener);
    }

    public void nouvellePartie(){
        undisplay();
        initAttribut(model.getNbJoueur());
        creerWidget(model.getNbJoueur());
        display();
    }
}
