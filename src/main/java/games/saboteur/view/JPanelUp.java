package games.saboteur.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class JPanelUp extends JPanel {
    private BufferedImage img;

    public JPanelUp(String file) {
        BufferedImage i;
        try {
            i = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException e) {
            i = null;
            System.out.println("didn't find it :(");
        }
        img = i;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0, 0,1500,600,this);
    }


}
