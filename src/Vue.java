import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Vue extends JFrame{
    protected Model model;

    protected JMenuItem nouveau, regle;
    public JButton bChoix[], bValid;
    public ArrayList<JButton> bPlus;
    protected JTextField tPseudo[];

    private JPanel pMenu, pPseudo[], plateau, panej1, panej2, panej3, panej4;
    public ScrollablePanel scrolplateau, j1, j2, j3, j4;

    public Vue(Model model) {
        this.model = model;

        initIntro();
        creerIntro();
        creerMenu();

        setTitle("TimeLine");
        setSize(1200, 900);
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

        j1 = initScrollableJoueur(BoxLayout.X_AXIS);
        j2 = initScrollableJoueur(BoxLayout.Y_AXIS);
        j3 = initScrollableJoueur(BoxLayout.X_AXIS);
        j4 = initScrollableJoueur(BoxLayout.Y_AXIS);

        for (Carte crt1 : model.joueur1.getMain()){ j1.add(crt1); }
        for (Carte crt2 : model.joueur2.getMain()){ j2.add(crt2); }
        for (Carte crt3 : model.joueur3.getMain()){ j3.add(crt3); }
        for (Carte crt4 : model.joueur4.getMain()){ j4.add(crt4); }

        j1.revalidate();
        j2.revalidate();
        j3.revalidate();
        j4.revalidate();

        JScrollPane js1 = new JScrollPane(j1,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        js1.setPreferredSize(new Dimension(680,270));
        JScrollPane js2 = new JScrollPane(j2,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        js2.setPreferredSize(new Dimension(180, 685));
        JScrollPane js3 = new JScrollPane(j3,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        js3.setPreferredSize(new Dimension(680,270));
        JScrollPane js4 = new JScrollPane(j4,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        js4.setPreferredSize(new Dimension(180,685));

        panej1 = new JPanel();
        panej2 = new JPanel();
        panej3 = new JPanel();
        panej4 = new JPanel();

        panej1.add(js1);
        panej2.add(js2);
        panej3.add(js3);
        panej4.add(js4);

        initPlateau();
        JScrollPane scrollPlateau = new JScrollPane(scrolplateau,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPlateau.setPreferredSize(new Dimension(680,270));
        scrollPlateau.setSize(new Dimension(685, 270));


        plateau = new JPanel();
        plateau.setLayout(new GridBagLayout());
        plateau.add(scrollPlateau);

    }

    public void creerWidget(){
        JPanel englobe = new JPanel();
        //englobe.setLayout(new BorderLayout(10,10));
        englobe.setLayout(new BoxLayout(englobe, BoxLayout.X_AXIS));
        /*for (JPanel p : pPseudo){
            englobe.add(p);
        }*/
        //englobe.add(bValid);

        JPanel milieu = new JPanel();
        milieu.setLayout(new BoxLayout(milieu,BoxLayout.Y_AXIS));
        milieu.add(panej1);
        milieu.add(plateau);
        milieu.add(panej3);

        englobe.add(panej4);
        englobe.add(milieu);
        englobe.add(panej2);


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

        bPlus = new ArrayList<JButton>();
        bPlus.add(new JButton("+"));
        scrolplateau.add(bPlus.get(0));
        for (Carte crt : model.plateau.getPlateau()){
            scrolplateau.add(crt);
            bPlus.add(new JButton("+"));
            scrolplateau.add(bPlus.get(bPlus.size()-1));
        }

        scrolplateau.revalidate();
        scrolplateau.repaint();
    }

    public void display(){setVisible(true);}
    public void undisplay(){setVisible(false);}


    public void setControlButton(ActionListener listener) {
        for(JButton b : bChoix){
            b.addActionListener(listener);
        }
        /*for(JButton bp : bPlus){
            bp.addActionListener(listener);
        }*/
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

    private ScrollablePanel initScrollableJoueur(int sensXouY){
        ScrollablePanel scrollable = new ScrollablePanel();
        scrollable.setLayout(new BoxLayout(scrollable, sensXouY));

        return scrollable;
    }
}
