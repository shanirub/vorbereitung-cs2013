public class Launcher {

    public static void main(String args[]) {
        Model model = new Model();
        model.initialise();
        MainFrame mainFrame = new MainFrame();
        Controller controller = new Controller(mainFrame, model);
        mainFrame.initialise(model, controller);
    }
}
