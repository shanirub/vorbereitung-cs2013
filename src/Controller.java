import javax.swing.*;
import javax.swing.event.MenuKeyListener;
import java.awt.*;
import java.awt.event.*;

// controller extends MouseAdapter and implements ActionListener
public class Controller extends MouseAdapter implements ActionListener {
    public Model model;
    public MainFrame view;
    private int index;
    private Color color;

    public Controller(MainFrame v, Model m) {
        view = v;
        model = m;
    }

    @Override
    // PRESSED - right or left click
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        int i = Integer.parseInt(((JLabel) e.getComponent()).getText());
        Color c = e.getComponent().getBackground();
        if (e.getComponent() instanceof JLabel) {
            if (e.getButton() == MouseEvent.BUTTON1) { // left click
                model.mixOneColor(index);
                view.repaint();
            } else if (e.getButton() == MouseEvent.BUTTON3) { // right click
                color = c;
                index = i;

                if (e.isPopupTrigger()) {
                    // don't use setVisible(true) but this instead: so it's a popup and in the right place
                    view.popupMenu.show((Component) e.getSource(), e.getX(), e.getY());
                }
            }
        }
    }

    @Override
    // clicking on a button or an a menu item
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("mix")) {
            model.mixAllColors();
        } else if (actionEvent.getActionCommand().equals("reset")) {
            model.resetAllColors();
        } else if (actionEvent.getActionCommand().equals("paste")) {
            model.copyColor(index, model.storedColour);
        } else if (actionEvent.getActionCommand().equals("copy")) {
            model.storedColour = color;
        }
        view.repaint();

    }
}
