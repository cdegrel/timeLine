import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vue extends JFrame{
    protected Model model;

    protected JMenuItem nouveau, regle;
    protected JTextField tPseudo[];
    protected JButton bValideNbJoueur;

    private JPanel pChoixNbJoueur[];

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
        tPseudo = new JTextField[model.getNB_MAX_JOUEUR()];
        pChoixNbJoueur = new JPanel[model.getNB_MAX_JOUEUR()];
        for (int i = 0; i < tPseudo.length; i++) {
            tPseudo[i] = new JTextField(10);
            pChoixNbJoueur[i] = new JPanel(new BorderLayout());
        }
        pChoixNbJoueur[0].add(tPseudo[0], BorderLayout.WEST);
        pChoixNbJoueur[1].add(tPseudo[1], BorderLayout.NORTH);
        pChoixNbJoueur[2].add(tPseudo[2], BorderLayout.EAST);
        pChoixNbJoueur[3].add(tPseudo[3], BorderLayout.SOUTH);

        bValideNbJoueur = new JButton("Valider");
    }

    public void creerIntro() {
        JPanel pValideNbJoueur = new JPanel(new BorderLayout());
        pValideNbJoueur.add(bValideNbJoueur, BorderLayout.CENTER);

        JPanel englobe = new JPanel();
        for (int i = 0; i < pChoixNbJoueur.length; i++) {
            englobe.add(pChoixNbJoueur[i]);
        }
        englobe.add(pValideNbJoueur);

        JPanel panel = new JPanel();
        panel.add(englobe);
        setContentPane(panel);
    }

    public void initAttribut(int n){

    }

    public void creerWidget(int n){

        JLabel ltest = new JLabel("test");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(ltest,BorderLayout.EAST);
        setContentPane(panel);
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
        bValideNbJoueur.addActionListener(listener);
    }

    public void setControlMenu(ActionListener listener) {
        nouveau.addActionListener(listener);
    }

    public void nouvellePartie(int n){
        initAttribut(n);
        creerWidget(n);
        display();
    }
}
