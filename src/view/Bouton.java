import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.io.*;

public class Bouton extends JButton {
	private String name;
	private Image img;
        static int n=0;

	
	public Bouton(String str){
	    super(str);
	    this.name = str;
	    try {
		img = ImageIO.read(new File("images/menuJeu"+n+".jpeg"));
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
