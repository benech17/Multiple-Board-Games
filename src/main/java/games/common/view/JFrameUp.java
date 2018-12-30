package games.common.view;

import javax.swing.*;
import java.awt.*;

public class JFrameUp extends JFrame {
     String image="landscape.png";

    public JFrameUp(){
        super();
        JPanel panel =new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                ImageIcon img=new ImageIcon(image);
                Image myImage=img.getImage();
                g.drawImage(myImage,0,0,this);
            }
        };
        getContentPane().add(panel);
    }


}
