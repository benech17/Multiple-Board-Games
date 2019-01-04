package games.saboteur.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Main extends JFrame {
    private JFrame mainMenu;

    public Main() {

        mainMenu = new JFrameUp();
        mainMenu.setTitle("Plateforme de jeux");
        mainMenu.setExtendedState(MAXIMIZED_BOTH | getExtendedState());
        mainMenu.setResizable(false);
        mainMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainMenu.getContentPane().setLayout(null);
        mainMenu.setLocationRelativeTo(null);  //centrer
        mainMenu.setMinimumSize(new Dimension(600, 600));

        Bouton DominoButton=new Bouton("Domino","menu");
	DominoButton.setBounds(200,200,400,150);
	DominoButton.setLocation(700,150);
	mainMenu.getContentPane().add(DominoButton);

	Bouton DominoGommetteButton=new Bouton("Gommette","menu");
	DominoGommetteButton.setBounds(200,200,400,150);
	DominoGommetteButton.setLocation(700,350);  //150+150 donc 50 espaces
	mainMenu.getContentPane().add(DominoGommetteButton);

	Bouton PuzzleButton=new Bouton("Puzzle","menu");
	PuzzleButton.setBounds(200,200,400,150);
	PuzzleButton.setLocation(700,550); //50 espaces
	mainMenu.getContentPane().add(PuzzleButton);

	Bouton SaboteurButton=new Bouton("Saboteur","menu");
	SaboteurButton.setBounds(200,200,400,150);
	SaboteurButton.setLocation(700,750);
	mainMenu.getContentPane().add(SaboteurButton);

        mainMenu.pack();
        mainMenu.setVisible(true);

        JLabel welcome = new JLabel("Bienvenue, veuillez choisir un jeu : ");
        welcome.setFont(new Font("Plain", Font.ITALIC | Font.BOLD, 20));
        welcome.setBounds(100, 50, 800, 80);
        mainMenu.getContentPane().add(welcome);

        try {  
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("livret.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Can't play music: livret.wav");
        }
        
        SaboteurButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChoicePlayers choicePlayers =new ChoicePlayers();
                mainMenu.setVisible(false);
            }
        });

       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { new Runnable(){
            @Override
            public void run(){
            try {
                Main frame = new Main();

            } catch (Exception e) {
                e.printStackTrace();
            }
            }
        });
    }

}


    

