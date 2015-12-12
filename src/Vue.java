import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Vue extends JFrame{
    protected Model model;
    public ControlPlus controlPlus;
    public ControlMouse controlMouse;

    protected JMenuItem nouveau, regle;
    public JButton bChoix[];
    public ArrayList<JButton> bPlus;

    private JPanel pMenu, plateau, panelJoueur[];
    public JTabbedPane tabPane;
    public ScrollablePanel scrolplateau;
    public JLabel labelDate;

    public Vue(Model model) {
        this.model = model;
        controlPlus = new ControlPlus(model,this);
        controlMouse = new ControlMouse(model,this);

        initIntro();
        creerIntro();
        creerMenu();

        setTitle("TimeLine");
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initIntro() {
        pMenu = new JPanel();

        JLabel lChoixJoueur = new JLabel("Choix du nombre de joueur");
        pMenu.add(lChoixJoueur);

        bChoix = new JButton[5];
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

    public void reInitTabPane() {
        for (int i = 0; i <model.getNbJoueur(); i++){
            panelJoueur[i].removeAll();
            for (Carte crt : model.joueurs[i].getMain()){
                if (crt.getMouseListeners().length == 0){
                    crt.addMouseListener(controlMouse);
                }
                panelJoueur[i].add(crt);
            }
        }
        tabPane.revalidate();
    }

    public void initAttribut(){
        panelJoueur = new JPanel[model.getNbJoueur()];
        tabPane = new JTabbedPane();

        for (int i = 0; i<model.getNbJoueur(); i++) {
            panelJoueur[i] = new JPanel();
            for (Carte crt : model.joueurs[i].getMain()){
                crt.addMouseListener(controlMouse);
                panelJoueur[i].add(crt);
            }

            panelJoueur[i].revalidate();
            tabPane.add("Joueur "+(i+1),panelJoueur[i]);

        }
        tabPane.setEnabled(false);

        initPlateau();
        JScrollPane scrollPlateau = new JScrollPane(scrolplateau,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPlateau.setPreferredSize(new Dimension(1550,365));
        scrollPlateau.setSize(new Dimension(1550, 365));


        plateau = new JPanel();
        plateau.setLayout(new GridBagLayout());
        plateau.add(scrollPlateau);

        labelDate = new JLabel(" ");
        labelDate.setPreferredSize(new Dimension(1550,20));

    }

    public void creerWidget(){
        JPanel englobe = new JPanel();
        //englobe.setLayout(new BorderLayout(10,10));
        englobe.setLayout(new BoxLayout(englobe, BoxLayout.Y_AXIS));

        englobe.add(plateau);
        englobe.add(labelDate);
        englobe.add(tabPane);

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
        JButton jb1 = new JButton("+");
        jb1.addActionListener(controlPlus);
        bPlus.add(jb1);
        scrolplateau.add(bPlus.get(0));
        for (Carte crt : model.plateau.getPlateau()){
            crt.addMouseListener(controlMouse);
            scrolplateau.add(crt);
            JButton jb = new JButton("+");
            jb.addActionListener(controlPlus);
            bPlus.add(jb);
            scrolplateau.add(bPlus.get(bPlus.size()-1));
        }

        scrolplateau.revalidate();
        scrolplateau.repaint();
    }

    public void joueurSuivant(){
        if (tabPane.getSelectedIndex() == model.getNbJoueur()-1){
            tabPane.setSelectedIndex(-1);
        }
        tabPane.setSelectedIndex(tabPane.getSelectedIndex()+1);
    }

    public void joueurGagne(){
        int joueurGagnant = model.testJoueurGagne();
        if (joueurGagnant >=0){
            int recommencer = JOptionPane.showConfirmDialog(this, "Le joueur "+(joueurGagnant+1)+" gagne. " +
                    "Voulez vous refaire une partie", "fin de partie", JOptionPane.YES_NO_OPTION);
            if (recommencer == JOptionPane.YES_OPTION) {
                undisplay();
                model = new Model();
                controlPlus = new ControlPlus(model,this);
                controlMouse = new ControlMouse(model,this);

                initIntro();
                creerIntro();
                creerMenu();

                setControlButton(new ControlButton(model, this));
                setControlMenu(new ControlMenu(this, model));
                nouveau.removeActionListener(nouveau.getActionListeners()[0]);
                regle.removeActionListener(regle.getActionListeners()[0]);
                display();
            }
            else {
                System.exit(0);
            }
        }
    }

    public void display(){setVisible(true);}
    public void undisplay(){setVisible(false);}


    public void setControlButton(ActionListener listener) {
        for(JButton b : bChoix){
            b.addActionListener(listener);
        }
    }

    public void addActionPlus(JButton jb){
        jb.addActionListener(controlPlus);
    }

    public void setControlMenu(ActionListener listener) {

        nouveau.addActionListener(listener);
        regle.addActionListener(listener);
    }

    public void nouvellePartie(){
        undisplay();
        initAttribut();
        creerWidget();
        display();
    }
}
