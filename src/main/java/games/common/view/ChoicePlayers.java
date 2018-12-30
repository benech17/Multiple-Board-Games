package games.core.view;

import games.saboteur.SaboteurGameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.Color.*;
import static java.awt.GridBagConstraints.*;

public class ChoicePlayers extends JFrame {
        private Container content;
        private int nbPlayers;

        public ChoicePlayers(){
            this.setTitle("Choix Joueurs");
            this.setExtendedState(MAXIMIZED_BOTH | getExtendedState());
            this.setDefaultCloseOperation(HIDE_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setMinimumSize(new Dimension(1300, 1000));
            this.setResizable(true);
            this.setLayout(new GridBagLayout());


            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets=new Insets(100,0, 100,0);
            gbc.ipady=50;
            this.content=getContentPane();
            content.setBackground(white);

            content.setPreferredSize(new Dimension(500,500));

            JLabel text=new JLabel("Choose how many players :");
            text.setFont(new Font("Plain",Font.BOLD,30));
            content.add(text,gbc);

           gbc.gridx=0; gbc.gridy=1; gbc.insets=new Insets(20,20,20,20);

            Bouton joueurs2=new Bouton("2 joueurs","");
            joueurs2.setPreferredSize(new Dimension(400,130));
            joueurs2.addActionListener(actionEvent -> nbPlayers=2);
            content.add(joueurs2,gbc);

            gbc.gridy=2;

            Bouton joueurs3=new Bouton("3 joueurs","");
            joueurs3.setPreferredSize(new Dimension(400,130));
            joueurs3.addActionListener(actionEvent -> nbPlayers=3);
            content.add(joueurs3,gbc);

            gbc.gridy=3;

            Bouton joueurs4=new Bouton("4 joueurs","");
            joueurs4.setPreferredSize(new Dimension(400,130));
            joueurs4.addActionListener(actionEvent -> nbPlayers=4 );


           content.add(joueurs4,gbc);



            gbc.insets=new Insets(50,400,0,0);
            gbc.anchor= LAST_LINE_END;
            gbc.gridx= RELATIVE;

            Bouton start =new Bouton("Let's play !","");
            start.setVisible(false);

            start.setPreferredSize(new Dimension(400,80));
            content.add(start,gbc);


            start.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("nbPlayers : "+nbPlayers);
                    SaboteurScreen s=new SaboteurScreen();
                    content.setVisible(false);


                    //getContentPane().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// tout mettre dans un panel ,
                }
            });

            class Clicklistener implements ActionListener{
                public void actionPerformed(ActionEvent e){
                    if(e.getSource() == joueurs2 || e.getSource()==joueurs3 || e.getSource()==joueurs4)
                        start.setVisible(true);
                }
            }
            Clicklistener click = new Clicklistener();
            joueurs4.addActionListener(click);
            joueurs3.addActionListener(click);
            joueurs2.addActionListener(click);

            this.pack();
            this.setVisible(true);
        }
        public static void main(String args){
                javax.swing.SwingUtilities.invokeLater(() -> {
                    try {
                        ChoicePlayers frame = new ChoicePlayers();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        }

}