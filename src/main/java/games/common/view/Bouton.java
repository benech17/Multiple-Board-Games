package games.common.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Bouton extends JButton {
    private String name;
    private Image img;
    static int m, n, i, k = 0;

    public Bouton(String str, String file) {
        super(str);
        this.name = str;
        try {
            this.addActionListener(event -> {
                //fonction de comparaisons a faire, limiter les clicks a 2 et bien verifier que c'est une carte de la main puis une case vide du plateau
                if (k % 2 != 0) {
                    this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.red));
                    k++;
                } else {
                    //if(this.getBorder()!=BorderFactory.createLineBorder(Color.black,2))
                    this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                    k++;
                }
            });

            if (Objects.equals(file, "start")) {
                img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/" + file + ".png"));
            } else {
                if (file.equals("goal")) {
                    m++;
                    System.out.println(m);
                    img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/goal" + m + ".png"));

                } else {

                    if (Objects.equals(file, "path")) {
                        n++;
                        img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/path" + n + ".png"));
                    } else {

                        if (Objects.equals(file, "menu")) {

                            img = ImageIO.read(getClass().getResourceAsStream("/images/menuJeu" + i + ".jpeg"));
                            i++;

                        } else {
                            img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/default.png"));
                            //img = ImageIO.read(new File("src/main/java/resources/images/saboteur/default.png"));
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Sans Serif", Font.BOLD, 40));
        g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() / 8) - 40, (this.getHeight() / 3));
    }


}
