import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.io.*;



public class Main extends JFrame{
    private JFrame mainMenu;
    	 static int n=0;
    

    public static void main(String [] args){
	SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run(){
		    try{
			Main frame =new Main();
			
		    }catch(Exception e ){
			e.printStackTrace();
		    }
		}
	    });
    }


    
    public Main(){
	
	mainMenu = new JFrame();
	mainMenu.setTitle("Plateforme de Jeux");
        //setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-80, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        mainMenu.setExtendedState(MAXIMIZED_BOTH | getExtendedState());
	mainMenu.setResizable(true);
	mainMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
	mainMenu.getContentPane().setLayout(null);
	mainMenu.setLocationRelativeTo(null);  //centrer

	Bouton DominoButton=new Bouton("Domino");
	DominoButton.setBounds(200,200,400,150);
	DominoButton.setLocation(700,150);
	mainMenu.getContentPane().add(DominoButton);

	Bouton DominoGommetteButton=new Bouton("Gommette");
	DominoGommetteButton.setBounds(200,200,400,150);
	DominoGommetteButton.setLocation(700,350);  //150+150 donc 50 espaces
	mainMenu.getContentPane().add(DominoGommetteButton);

	Bouton PuzzleButton=new Bouton("Puzzle");
	PuzzleButton.setBounds(200,200,400,150);
	PuzzleButton.setLocation(700,550); //50 espaces
	mainMenu.getContentPane().add(PuzzleButton);

	Bouton SaboteurButton=new Bouton("Saboteur");
	SaboteurButton.setBounds(200,200,400,150);
	SaboteurButton.setLocation(700,750);
	mainMenu.getContentPane().add(SaboteurButton);


	mainMenu.pack();
	mainMenu.setVisible(true);


		DominoButton.addMouseListener(new MouseAdapter(){
		@Override
		public void mouseClicked(MouseEvent e){
		Domino d=new Domino(mainMenuPrincipal);
		mainMenuPrincipal.setVisible(false);
		d.DominoScreen();
		}
		});
     
    }

   /* public class Panneau extends JPanel {

	private final Image img;

	public Panneau(){
	    img=Toolkit.getDefaultToolkit().createImage("landscape.png");
	}
	public void paintComponent(Graphics g){
	  
	    //Pour une image de fond
	    g.drawImage(img, 0,0, this);
	            
	}
    }*/


    public class Bouton extends JButton {
	private String name;
	private Image img;

	
	public Bouton(String str){
	    super(str);
	    this.name = str;
	    try {
		img = ImageIO.read(new File("assets/images/menuJeu"+n+".jpeg"));
		n++;
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

    
        
	public void paintComponent(Graphics g){
	    Graphics2D g2d = (Graphics2D)g;
	    // GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
	    //g2d.setPaint(gp);
	    g2d.drawImage(img,0, 0, this.getWidth(), this.getHeight(),this);
	    g2d.setColor(Color.BLACK);
	    g2d.setFont(new Font("Sans Serif",Font.BOLD,40));
	    g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth()/8)-40, (this.getHeight() / 3) );
	}        
    }
}
