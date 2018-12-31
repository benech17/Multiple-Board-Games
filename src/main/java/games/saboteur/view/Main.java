package games.saboteur.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Main extends JFrameUp {
    private JFrameUp mainMenu;

    public Main() {

        mainMenu = new JFrameUp();
        //mainMenu.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./landscape.png")))));
        mainMenu.setTitle("Jeu du saboteur");
        mainMenu.setExtendedState(MAXIMIZED_BOTH | getExtendedState());
        mainMenu.setResizable(false);
        mainMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainMenu.getContentPane().setLayout(null);
        mainMenu.setLocationRelativeTo(null);  //centrer
        mainMenu.setMinimumSize(new Dimension(600, 600));

        Bouton SaboteurButton = new Bouton("Saboteur", "menu");
        SaboteurButton.setBounds(200, 200, 400, 150);
        SaboteurButton.setLocation(200, 250);
        mainMenu.getContentPane().add(SaboteurButton);

        mainMenu.pack();
        mainMenu.setVisible(true);

        JLabel welcome = new JLabel("Bienvenue, veuillez choisir un jeu : ");
        welcome.setFont(new Font("Plain", Font.ITALIC | Font.BOLD, 20));
        welcome.setBounds(100, 50, 800, 80);
        mainMenu.getContentPane().add(welcome);

        SaboteurButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChoicePlayers choicePlayers =new ChoicePlayers();
                mainMenu.setVisible(false);
            }
        });

        SaboteurButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SaboteurScreen saboteur = new SaboteurScreen();
                mainMenu.setVisible(false);

            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Main frame = new Main();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}


    

