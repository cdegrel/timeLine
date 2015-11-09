import javax.swing.*;
import java.awt.event.ActionListener;

public class Vue extends JFrame{
    protected Model model;

    public Vue(Model model) {
        this.model = model;

        initAttribut();
        creerVue();
        pack();

        setTitle("TimeLine");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initAttribut() {

    }

    private void creerVue() {

    }

    public void display(){
        setVisible(true);
    }


    public void setControlButton(ActionListener listener) {

    }

    public void setControlMenu(ActionListener listener) {

    }
}
