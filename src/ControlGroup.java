public class ControlGroup {
    protected Model model;
    protected Vue vue;

    public ControlMenu cm;
    public ControlButton cb;

    public ControlGroup(Model mod) {
        model = mod;
        vue = new Vue(model);

        cb = new ControlButton(model, vue);
        cm = new ControlMenu(vue, model);

        vue.display();
    }

}
