import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
        JPanel colorPanel, buttonPanel;
        JLabel[] labels;
        JButton mix, reset;
        public Model model;
        Controller controller;
        JPopupMenu popupMenu;

    @Override
    // not called directly, only with repaint
    public void paint(Graphics g) {
        super.paint(g);
        Color[] colors = model.getColours();
        for (int i = 0; i < 49; i++) {
            labels[i].setBackground(colors[i]);
        }
    }

    public void buildMenu() {
        popupMenu = new JPopupMenu();

        // for each item: 1. create JMenuItem. 2. assign action command. 3. assign action listener 4. add to the JPopupMenu
        JMenuItem mix_menu = new JMenuItem("Mix");
        mix_menu.setActionCommand("mix");
        JMenuItem reset_menu = new JMenuItem("Reset");
        reset_menu.setActionCommand("reset");
        JMenuItem copy_menu = new JMenuItem("Copy");
        copy_menu.setActionCommand("copy");
        JMenuItem paste_menu = new JMenuItem("Paste");
        paste_menu.setActionCommand("paste");

        mix_menu.addActionListener(controller);
        reset_menu.addActionListener(controller);
        copy_menu.addActionListener(controller);
        paste_menu.addActionListener(controller);

        popupMenu.add(mix_menu);
        popupMenu.add(reset_menu);
        popupMenu.add(copy_menu);
        popupMenu.add(paste_menu);

    }

    public void initialise(Model m, Controller c) {
        model = m;
        controller = c;

        this.setTitle("Mosaic");

        colorPanel = new JPanel();
        buttonPanel = new JPanel();

        colorPanel.setPreferredSize(new Dimension(400, 400));
        colorPanel.setBackground(Color.LIGHT_GRAY);

        GridLayout gridLayout = new GridLayout(7,7);
        colorPanel.setLayout(gridLayout);

        this.setLayout(new BorderLayout());

        labels = new JLabel[49];
        for (int i = 0; i < 49; i++) {
            labels[i] = new JLabel(String.valueOf(i));
            labels[i].setOpaque(true);  // IMPORTANT! opaque means not transparent and so must be true
            labels[i].setVisible(true);
            labels[i].addMouseListener(controller); // mouse listener
            colorPanel.add(labels[i], i);
        }

        colorPanel.setVisible(true);

        // for each button: 1. create JButton. 2. assign action command. 3. assign action listener. 4. add to button panel
        mix = new JButton("Mix");
        reset = new JButton("Reset");

        mix.addActionListener(controller);
        reset.addActionListener(controller);
        mix.setActionCommand("mix");
        reset.setActionCommand("reset");
        buttonPanel.add(mix);
        buttonPanel.add(reset);


        this.add(colorPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);

        buildMenu();

        this.pack(); // adjust size to included components
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
