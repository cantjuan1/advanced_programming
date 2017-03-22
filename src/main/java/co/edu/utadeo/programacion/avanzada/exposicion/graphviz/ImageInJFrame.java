package co.edu.utadeo.programacion.avanzada.exposicion.graphviz;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ImageInJFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 5804753285455976072L;

    public static void main(String args[]) {
        new ImageInJFrame().start("");
    }

    public void start(String image) {
        ImageImplement panel;
        panel = new ImageImplement(new ImageIcon(image).getImage());
        add(panel);
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
