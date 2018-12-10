package org.julienyaniv.pooig.view;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{
    private JFrame mainMenu;


    public Main(){

        mainMenu = new JFrame();
        mainMenu.setTitle("Plateforme de Jeux");
        //setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-80, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        mainMenu.setExtendedState(MAXIMIZED_BOTH | getExtendedState());
        mainMenu.setResizable(true);
        mainMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainMenu.getContentPane().setLayout(null);
        mainMenu.setLocationRelativeTo(null);  //centrer

        Bouton DominoButton = new Bouton("Domino");
        DominoButton.setBounds(200, 200, 400, 150);
        DominoButton.setLocation(700, 150);
        mainMenu.getContentPane().add(DominoButton);

        Bouton DominoGommetteButton = new Bouton("Gommette");
        DominoGommetteButton.setBounds(200, 200, 400, 150);
        DominoGommetteButton.setLocation(700, 350);  //150+150 donc 50 espaces
        mainMenu.getContentPane().add(DominoGommetteButton);

        Bouton PuzzleButton = new Bouton("Puzzle");
        PuzzleButton.setBounds(200, 200, 400, 150);
        PuzzleButton.setLocation(700, 550); //50 espaces
        mainMenu.getContentPane().add(PuzzleButton);

        Bouton SaboteurButton = new Bouton("Saboteur");
        SaboteurButton.setBounds(200, 200, 400, 150);
        SaboteurButton.setLocation(700, 750);
        mainMenu.getContentPane().add(SaboteurButton);

        mainMenu.pack();
        mainMenu.setVisible(true);

        JLabel welcome = new JLabel("Bienvenue, veuillez choisir un jeu : ");
        welcome.setFont(new Font("Plain", Font.ITALIC | Font.BOLD, 20));
        welcome.setBounds(100, 50, 800, 80);
        mainMenu.getContentPane().add(welcome);

	/*
	  DominoButton.addMouseListener(new MouseAdapter(){
	  @Override
	  public void mouseClicked(MouseEvent e){
	  Domino d=new Domino(mainMenuPrincipal);
	  mainMenuPrincipal.setVisible(false);
	  d.DominoScreen();
	  }
	  });*/

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Main frame = new Main();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*  public class Panneau extends JPanel {

	private final Image img;

	public Panneau(){
	    img=Toolkit.getDefaultToolkit().createImage("landscape.png");
	}
	public void paintComponent(Graphics g){
	  
	    //Pour une image de fond
	    g.drawImage(img, 0,0, this);
	            
	}
    }*/
}


    

