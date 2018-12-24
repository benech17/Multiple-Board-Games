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
    static int m,n,i,k=0;
	
    public Bouton(String str,String file){
	super(str);
	this.name = str;
	try {
	    this.addActionListener( event ->{ 
		    //fonction de comparaisons a faire, limiter les clicks a 2 et bien verifier que c'est une carte de la main puis une case vide du plateau
		    if(k%2!=0){ 
			this.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.red)); 
			k++;
		    }else{
			//if(this.getBorder()!=BorderFactory.createLineBorder(Color.black,2))	
			this.setBorder(BorderFactory.createLineBorder(Color.black,2)) ;
			k++;
		    } 
		});

	    if(file=="start"){
		img = ImageIO.read(new File("images/saboteur/"+file+".png"));
	    }else{
		if(file.equals("goal")){
		    m++;
		    img = ImageIO.read(new File("images/saboteur/goal"+m+".png"));
		    
		}else{
		
		    if(file=="path"){
			n++;
			img = ImageIO.read(new File("images/saboteur/path"+n+".png"));
		    }else{

			if(file=="menu"){
			
			    img = ImageIO.read(new File("images/menuJeu"+i+".jpeg"));
			    i++;
			    
			}else{
			    img = ImageIO.read(new File("images/saboteur/default.png"));
			}
		    }
		}
	    }
		
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    
        
    public void paintComponent(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.drawImage(img,0, 0, this.getWidth(), this.getHeight(),this);
	g2d.setColor(Color.BLACK);
	g2d.setFont(new Font("Sans Serif",Font.BOLD,40));
	g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth()/8)-40, (this.getHeight() / 3) );
    }
	
	        
}
