import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu implements ActionListener {
    protected Vue vue;
    protected Model model;

    public ControlMenu(Vue vue, Model model){
        this.vue = vue;
        this.model = model;

        vue.setControlMenu(this);
    }

    public void actionPerformed(ActionEvent e){

    }
}
