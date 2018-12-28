package games.common.view;

import javax.swing.*;
import java.awt.*;


public class SaboteurScreen extends JFrame {
    public SaboteurScreen() {
        this.setTitle("Saboteur");

        this.setExtendedState(MAXIMIZED_BOTH | getExtendedState());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(600, 600));


        JPanel plateau = new JPanel();
        plateau.setBackground(Color.white);
        plateau.setMinimumSize(new Dimension(600, 600));
        plateau.setPreferredSize(new Dimension(1500, 500));

        plateau.setLayout(new GridLayout(5, 9, 15, 15));


        //plateau.add(new Bouton("a","start") ,19) ;

        //for(int i=1;i<19;i++){

        //if(i==9 || i==27||i==45){
        //plateau.add(new Bouton("a","goal"),i);
        //}
        //else{
        //   plateau.add(new Bouton("a","d"),i);


        Bouton n1 = new Bouton("test", "default");
        plateau.add(n1);

        Bouton n2 = new Bouton("test", "default");
        plateau.add(n2);

        Bouton n3 = new Bouton("test", "default");
        plateau.add(n3);

        Bouton n4 = new Bouton("test", "default");
        plateau.add(n4);

        Bouton n5 = new Bouton("test", "default");
        plateau.add(n5);

        Bouton n6 = new Bouton("test", "default");
        plateau.add(n6);

        Bouton n7 = new Bouton("test", "default");
        plateau.add(n7);


        Bouton n8 = new Bouton("test", "default");
        plateau.add(n8);

        Bouton n9 = new Bouton("test", "goal");
        plateau.add(n9);


        Bouton n10 = new Bouton("test", "default");
        plateau.add(n10);

        Bouton n11 = new Bouton("test", "default");
        plateau.add(n11);

        Bouton n12 = new Bouton("test", "default");
        plateau.add(n12);

        Bouton n13 = new Bouton("test", "default");
        plateau.add(n13);


        Bouton n14 = new Bouton("test", "default");
        plateau.add(n14);

        Bouton n15 = new Bouton("test", "default");
        plateau.add(n15);

        Bouton n16 = new Bouton("test", "default");
        plateau.add(n16);

        Bouton n17 = new Bouton("test", "default");
        plateau.add(n17);

        Bouton n18 = new Bouton("test", "default");
        plateau.add(n18);


        Bouton n19 = new Bouton("test", "start");
        plateau.add(n19);

        Bouton n20 = new Bouton("test", "default");
        plateau.add(n20);


        Bouton n21 = new Bouton("test", "default");
        plateau.add(n21);

        Bouton n22 = new Bouton("test", "default");
        plateau.add(n22);

        Bouton n23 = new Bouton("test", "default");
        plateau.add(n23);


        Bouton n24 = new Bouton("test", "default");
        plateau.add(n24);


        Bouton n25 = new Bouton("test", "default");
        plateau.add(n25);


        Bouton n26 = new Bouton("test", "default");
        plateau.add(n26);


        Bouton n27 = new Bouton("test", "goal");
        plateau.add(n27);


        Bouton n28 = new Bouton("test", "default");
        plateau.add(n28);

        Bouton n29 = new Bouton("test", "default");
        plateau.add(n29);


        Bouton n30 = new Bouton("test", "default");
        plateau.add(n30);


        Bouton n31 = new Bouton("test", "default");
        plateau.add(n31);


        Bouton n32 = new Bouton("test", "default");
        plateau.add(n32);


        Bouton n33 = new Bouton("test", "default");
        plateau.add(n33);


        Bouton n34 = new Bouton("test", "default");
        plateau.add(n34);


        Bouton n35 = new Bouton("test", "default");
        plateau.add(n35);


        Bouton n36 = new Bouton("test", "default");
        plateau.add(n36);


        Bouton n37 = new Bouton("test", "default");
        plateau.add(n37);


        Bouton n38 = new Bouton("test", "default");
        plateau.add(n38);

        Bouton n39 = new Bouton("test", "default");
        plateau.add(n39);


        Bouton n40 = new Bouton("test", "default");
        plateau.add(n40);


        Bouton n41 = new Bouton("test", "default");
        plateau.add(n41);


        Bouton n42 = new Bouton("test", "default");
        plateau.add(n42);


        Bouton n43 = new Bouton("test", "default");
        plateau.add(n43);


        Bouton n44 = new Bouton("test", "default");
        plateau.add(n44);

        Bouton n45 = new Bouton("test", "goal");
        plateau.add(n45);


        JPanel cell2 = new JPanel();
        cell2.setBackground(Color.red);
        cell2.setPreferredSize(new Dimension(200, 500));

        JPanel main = new JPanel();
        main.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new Insets(10, 10, 10, 10);
        gb.gridx = 0;
        gb.gridy = 0;

        Bouton test = new Bouton("test", "path");
        test.setPreferredSize(new Dimension(100, 100));
        main.add(test, gb);
        gb.gridx = 1;

        Bouton test1 = new Bouton("test", "path");
        test1.setPreferredSize(new Dimension(100, 100));
        main.add(test1, gb);

        gb.gridx = 2;
        Bouton test2 = new Bouton("test", "path");
        test2.setPreferredSize(new Dimension(100, 100));

        main.add(test2, gb);
        Bouton test3 = new Bouton("test", "path");
        test3.setPreferredSize(new Dimension(100, 100));
        gb.gridx = 3;
        main.add(test3, gb);

        Bouton test4 = new Bouton("test", "default");
        test4.setPreferredSize(new Dimension(100, 100));
        gb.gridx = 4;
        main.add(test4, gb);
        main.setBackground(Color.green);
        main.setPreferredSize(new Dimension(1500, 200));


        JPanel cell4 = new JPanel();
        cell4.setBackground(Color.pink);
        cell4.setPreferredSize(new Dimension(200, 200));


        //Le conteneur principal,penser a tout mettre dans un conteneur principal
        JPanel content = new JPanel();
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(cell2, gbc);

        gbc.gridx = 1;
        add(plateau, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        add(main, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        add(cell4, gbc);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                SaboteurScreen frame = new SaboteurScreen();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void display(String s) {
        javax.swing.SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, s, "Attention", JOptionPane.INFORMATION_MESSAGE));
    }
}
