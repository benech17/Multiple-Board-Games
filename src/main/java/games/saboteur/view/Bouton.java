package games.saboteur.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Bouton extends JButton {
    private String name;
    private Image img;
    // inutile static int m, n, i, k = 0;

    public Bouton(String str, String file) {
        super(str);
        this.name = str;
        setForeground(Color.BLACK);
        setBorder(null);

        try {
            this.addActionListener(event -> {  //test pour recuperer les donnees du click
            //et voir comment pouvoir recuperer l'indice du composant clicker dans le background
            //manque de temps.... 
                System.out.println(event.toString());System.out.println();
                System.out.println(event.getActionCommand());System.out.println();
                System.out.println(event.getSource());
                System.out.println();
                System.out.println(event.paramString());


                //fonction de comparaisons a faire, limiter les clicks a 2 et bien verifier que c'est une carte de la main puis une case vide du plateau
                if (k % 2 != 0 ) {
                    this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.red));
                    k++;
                } else {
                    //if(this.getBorder()!=BorderFactory.createLineBorder(Color.black,2))
                    this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                    k++;
                }
            });
                //todo : reorganiser avec switch et toutes les images
            switch (file) {
                case "start":
                    img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/" + file + ".png"));
                    break;
                case "treasure":
                    img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/goal1.png"));
                    break;
                case "goal":
                    img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/goal2.png"));
                    break;
                case "pass":
                    img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/pass.png"));
                    break;
            }
            //img = ImageIO.read(getClass().getResourceAsStream(file));
//            if (Objects.equals(file, "start")) {
//                img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/" + file + ".png"));
//            } else {
//                if (file.equals("goal")) {
//                    System.out.println(m);
//                    img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/goal" + m + ".png"));
//
//                } else {
//                    if (Objects.equals(file, "pass")) {
//                        n++;
//                        img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/pass.png"));
//                    } else {
//
//                        if (Objects.equals(file, "path")) {
//                            n++;
//                            img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/path" + n + ".png"));
//                        } else {
//
//                            if (Objects.equals(file, "menu")) {
//
//                                img = ImageIO.read(getClass().getResourceAsStream("/images/menuJeu" + i + ".jpeg"));
//                                i++;
//
//                            } else {
//                                img = ImageIO.read(getClass().getResourceAsStream("/images/saboteur/default.png"));
//                                //img = ImageIO.read(new File("src/main/java/resources/images/saboteur/default.png"));
//                            }
//                        }
//                    }
//                }
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bouton(String file){
        this("",file);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Sans Serif", Font.BOLD, 40));
        g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() / 8) - 40, (this.getHeight() / 3));
    }

    //methodes utiles pour les box pour le panel infos joueurs
    public void addToBox(Box box, boolean vertical,int w,int h) {
        Box box1;
        if (vertical)
            box1 = Box.createVerticalBox();
        else
            box1 = Box.createHorizontalBox();
        box1.add(this);
        box.add(box1);
        if (w != 0 || h != 0) addEmptyBox(box, w, h);
    }

    public void addToBox(Box box,boolean vertical) {
        addToBox(box, vertical, 0, 0);
    }

    public void addEmptyBox(Box box,int w,int h) {
        box.add(Box.createRigidArea(new Dimension(w, h)));
    }


}
