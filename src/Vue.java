import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vue extends JFrame{
    protected Model model;

    protected JMenuItem nouveau, regle;
    protected JButton bChoix[], bValid;
    protected JTextField tPseudo[];

    private JPanel pMenu, pPseudo[], plateau;
    private JPanel j1, j2, j3, j4;
    private ScrollablePanel scrolplateau;

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

    public void initAttribut(){
        /*tPseudo = new JTextField[model.getNbJoueur()];
        pPseudo = new JPanel[model.getNbJoueur()];
        for (int i = 0; i < model.getNbJoueur(); i++) {
            tPseudo[i] = new JTextField(10);
            pPseudo[i].add(tPseudo[i]);
        }
        bValid = new JButton("Jouer");*/
        j1 = new JPanel();
        j1.add(new JLabel("joueur 1"));
        j2 = new JPanel();
        j2.add(new JLabel("joueur 2"));
        j3 = new JPanel();
        j3.add(new JLabel("joueur 3"));
        j4 = new JPanel();
        j4.add(new JLabel("joueur 4"));

        initPlateau();
        JScrollPane scrollPlateau = new JScrollPane(scrolplateau,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPlateau.setPreferredSize(new Dimension(700,300));
        scrollPlateau.setMaximumSize(new Dimension(700,300));


        plateau = new JPanel();
        plateau.setLayout(new GridBagLayout());
        plateau.add(scrollPlateau);

    }

    public void creerWidget(){
        JPanel englobe = new JPanel();
        englobe.setLayout(new BorderLayout(10,10));
        /*for (JPanel p : pPseudo){
            englobe.add(p);
        }*/
        //englobe.add(bValid);

        englobe.add(plateau, BorderLayout.CENTER);
        englobe.add(j1, BorderLayout.PAGE_END);
        englobe.add(j2, BorderLayout.EAST);
        englobe.add(j3, BorderLayout.PAGE_START);
        englobe.add(j4, BorderLayout.WEST);
        setContentPane(englobe);
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

    public void initPlateau(){
        scrolplateau = new ScrollablePanel();
        scrolplateau.setLayout(new BoxLayout(scrolplateau, BoxLayout.X_AXIS));
        for (Carte crt : model.plateau.getPlateau()){
            scrolplateau.add(crt);
            scrolplateau.add(new JButton("+"));
        }

        scrolplateau.setPreferredSize(new Dimension(1500, 270));
        scrolplateau.repaint();
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
        initAttribut();
        creerWidget();
        display();
    }
}
