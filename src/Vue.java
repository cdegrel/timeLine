import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vue extends JFrame{
    protected Model model;

    protected JMenuItem nouveau, regle;

    public Vue(Model model) {
        this.model = model;

        initAttribut();
        creerVue();

        setTitle("TimeLine");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initAttribut() {

    }

    private void creerVue() {
        //==============================*Menu*
        JMenuBar menu = new JMenuBar();
        JMenu options = new JMenu("Options");
        options.add(nouveau = new JMenuItem("Nouvelle partie"));
        options.addSeparator();
        options.add(regle = new JMenuItem("Regle du jeu"));
        menu.add(options);
        setJMenuBar(menu);

    }

    public void display(){setVisible(true);}
    public void undisplay(){
        setVisible(false);
    }


    public void setControlButton(ActionListener listener) {

    }

    public void setControlMenu(ActionListener listener) {
        nouveau.addActionListener(listener);
    }
}
