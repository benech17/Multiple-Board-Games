package games.saboteur.view;

import games.common.model.board.Coordinate;
import games.saboteur.SaboteurBoard;
import games.saboteur.SaboteurGameState;
import games.saboteur.SaboteurHand;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.actioncard.BlockCard;
import games.saboteur.cards.actioncard.RepairCard;
import games.saboteur.cards.pathcard.GoalCard;
import games.saboteur.cards.pathcard.SaboteurTile;
import games.saboteur.cards.pathcard.StartCard;
import games.saboteur.cards.pathcard.TreasureCard;

import javax.swing.*;
import java.awt.*;


public class SaboteurScreen extends JFrame implements SaboteurView {
    private int nbPlayers;
    private SaboteurGameState gameState;


    public SaboteurScreen() {

        gameState = new SaboteurGameState(3);

        System.out.println(nbPlayers);
        this.setTitle("Saboteur");
        this.setExtendedState(MAXIMIZED_BOTH | getExtendedState());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(600, 600));


        JPanelUp plateau = new JPanelUp("/images/saboteur/background.jpg/");

        plateau.setMinimumSize(new Dimension(600, 600));
        plateau.setPreferredSize(new Dimension(1500, 500));

        plateau.setLayout(new GridLayout(5, 9, 15, 15));


        SaboteurBoard board = gameState.getBoard();

        SaboteurTile t;
        System.out.println(board.getHeight() + " " + board.getLength());
        int id = 0;
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getLength(); j++) {
                t = board.getTileAt(new Coordinate(i, j));
                System.out.println(t);
                if (t == null) {
                    plateau.add(new Bouton("a", "default"));
                } else if (t instanceof StartCard) {
                    plateau.add(new Bouton("a", "start"));
                } else if (t instanceof GoalCard) {
                    if (t instanceof TreasureCard) {
                        plateau.add(new Bouton("", "treasure"));
                    } else {
                        plateau.add(new Bouton("", "goal"));
                    }
                } else {
                    plateau.add(new Bouton("test", "default"));
                }
                id++;
            }
        }
        System.out.println(id);

        //for(int i=1;i<19;i++){

        //if(i==9 || i==27||i==45){
        //plateau.add(new Bouton("a","goal"),i);
        //}
        //else{
        //   plateau.add(new Bouton("a","d"),i);



        JPanel cell2 = new JPanel();
        cell2.setBackground(Color.red);
        cell2.setPreferredSize(new Dimension(200, 500));

        JPanelUp main = new JPanelUp("/images/saboteur/background.png/");
        main.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new Insets(10, 10, 10, 10);
        gb.gridx = 0;
        gb.gridy = 0;

        //printPlayers();
        //printHand();


        SaboteurHand hand = (SaboteurHand) gameState.getPlayers().get(0).getHand();
        int i = 0;
        for (SaboteurCard c : hand.getHand()) {
            System.out.println(i + " - " + c.toString());
            //System.out.println(c instanceof  RepairCard);
            //System.out.println(c instanceof BlockCard);;
            //System.out.println(c instanceof SaboteurTile);
        }
        for (SaboteurCard c : hand.getHand()) {
            if (c instanceof RepairCard) {
                Bouton handC = new Bouton("", "pass");

                handC.setPreferredSize(new Dimension(100, 100));
                gb.gridx = i;
                main.add(handC, gb);
                System.out.println("rep");
                i++;
            }
            if (c instanceof BlockCard) {
                Bouton handC = new Bouton("", "start");
                System.out.println(((BlockCard) c).getType());
                handC.setPreferredSize(new Dimension(100, 100));
                gb.gridx = i;
                main.add(handC, gb);
                System.out.println("bl");
                i++;
            }
            if (c instanceof SaboteurTile) {
                Bouton handC = new Bouton("", "path");
                handC.setPreferredSize(new Dimension(100, 100));
                gb.gridx = i;
                main.add(handC, gb);
                System.out.println("ti");
                i++;
            }
        }


        gb.gridx = 5;
        gb.insets = new Insets(0, 50, 0, 10);
        JLabel current = new JLabel("Current Player : ");
        current.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 15));
        main.add(current, gb);
        main.setBackground(Color.green);
        main.setPreferredSize(new Dimension(1500, 200));


        JPanel trash = new JPanel();
        trash.setPreferredSize(new Dimension(200, 200));
        Bouton pass = new Bouton("", "pass");
        pass.setPreferredSize(new Dimension(180, 170));
        pass.setBorder(null);
        trash.add(pass);


        //Le conteneur principal,penser a tout mettre dans un conteneur principal

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
        add(trash, gbc);

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

    public String displayInput(String message,String initialSelectionValue) {
        String res = (String) JOptionPane.showInputDialog(null, message, initialSelectionValue);
        if (res != null) {
            return res;
        } else {
            display("Cannot affect null value, please enter a correct input");
            return displayInput(message, initialSelectionValue);
        }
    }





    public String[] display2Inputs(String message){

        JTextField xField = new JTextField(1);
        JTextField yField = new JTextField(1);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);

        String[] res = JOptionPane.showConfirmDialog(null,myPanel, "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if(res[0]==null || res[1]==null || res[0].length()=0 || res[1].length()=0){
            display("Cannot affect null value");
            return display2Inputs();
        }else{
            res[0]=xField.getText());
            res[1]=yField.getText());
            System.out.println(res);
        }
    }


    public String displayChoice(String message,String initialValue,String[] pz,String titre){
            String s=(String)JOptionPane.showInputDialog(null,message,titre,JOptionPane.QUESTION_MESSAGE, null, pz, "t");
        if (s != null && s.length() > 0){
            return s;
        }else{
            display("Cannot affect null value, please enter a correct input");
            return displayChoice(message,pz,titre);
        }
    }

    @Override
    public void setGameState(SaboteurGameState gameState){
        this.gameState=gameState;
    }

    @Override
    public void printPassTurn(){
        display("Player " + gameState.getCurrentPlayer() + " has passed their turn");
    }

    @Override
    public void printError(Throwable t){
        display(t.toString());
    }

    @Override
    public void printWrongAction() {
       display("Please enter a valid integer (either 0 or 1)");
    }

    String[] handChoice={0,1,2,3,4}; //constant

    @Override
    public int selectCardToPutToTrash(){
        String res =displayChoice("Index of the card to put to the trash : ","0",handChoice,"Which card");
        return Integer.parseInt(res);
    }

    @Override
    public  void printPlayerWon(){
        display(gameState.getCurrentPlayer()+" has won !");
    }

    @Override
    public int selectPlayer(){
        String res=displayChoice("Index of the player to put the card in front of : ","0",gameState.getPlayers(),"Which Player");
        return Integer.parseInt(res);
    }

    @Override
   // public Coordinate selectCoordinate(){
      //  String res = display2Inputs()
    //}

    @Override
    public int selectCardToPlay(){ //isVerify? wrongCardException
        String res =displayChoice("Index of the card to play","0",handChoice,"Which card");
        return Integer.parseInt(res);
    }

    @Override
    public void printWrongIndex() {
        display("Wrong index, please retry");
    }

    @Override
    public int chooseAction(){
        String res=displayInput("Choose your action (0 : pass, 1 : play a card) : ","0");
        return  Integer.parseInt(res);
    }

    @Override
    public void printPlayers() {
        JPanel infos = new JPanel();
        infos.setPreferredSize(new Dimension(200, 500));
        infos.setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.gridx=GridBagConstraints.RELATIVE;
        JLabel titre=new JLabel("Players :");
        titre.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
        constraints.insets=new Insets(10,0,30,10);
        infos.add(titre,constraints);
        for(int i=0;i<gameState.getPlayers().size();i++){
            constraints.gridy=i+1;
            constraints.insets=new Insets(20,0,20,0);
            JLabel p = new JLabel (i+" : "+gameState.getPlayers().get(i).toString());
            p.setFont(new Font(Font.SANS_SERIF,Font.CENTER_BASELINE,20));
            p.setForeground(Color.red);
            infos.add(p,constraints);
            if(gameState.getPlayers().get(i).getBlockCards().size()!=0) {
                constraints.insets=new Insets(10,0,10,0);
                JLabel blockC = new JLabel(gameState.getPlayers().get(i).getBlockCards().toString());
                blockC.setFont(new Font(Font.SERIF, Font.ITALIC, 12));
                blockC.setForeground(Color.darkGray);
                infos.add(blockC, constraints);
            }
        }


    }

    public void printHand() {
        System.out.println(gameState.getCurrentPlayer() + " hand (listed by index):");
        SaboteurHand hand = (SaboteurHand) gameState.getCurrentPlayer().getHand();
        int i = 0;
        for (SaboteurCard c : hand.getHand()) {
            if (c instanceof RepairCard) {
                Bouton handC = new Bouton("", "pass");

                handC.setPreferredSize(new Dimension(100, 100));
                gb.gridx = i;
                main.add(handC, gb);
                i++;
            } else {
                if (c instanceof BlockCard) {
                    Bouton handC = new Bouton("", "start");
                    handC.setPreferredSize(new Dimension(100, 100));
                    gb.gridx = i;
                    main.add(handC, gb);
                    i++;
                } else {
                    if (c instanceof SaboteurTile) {
                        Bouton handC = new Bouton("", "path");
                        handC.setPreferredSize(new Dimension(100, 100));
                        gb.gridx = i;
                        main.add(handC, gb);
                        i++;
                    }
                }
            }
        }
    }

    @Override
    public void printCurrentPlayer() {
        gb.insets=new Insets(0,45,0,0);
        gb.gridx=6;
        JLabel currentP =gameState.getCurrentPlayer().toString();
        currentP.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
        main.add(currentP,gb);
    }

    /*
    public void printBlockCards() {
        System.out.print("Block cards applied to " + gameState.getCurrentPlayer() + " : ");
        HashMap<ActionCardType, BlockCard> blockCards = gameState.getCurrentPlayer().getBlockCards();
        for (BlockCard blockCard : blockCards.values()) {
            System.out.print(blockCard + ", ");
        }
        System.out.println("\n");
    }

    public void printBoard() {
        System.out.println("The board : \n");
        System.out.println(gameState.getBoard());
    }*/


    @Override
    public int getNbPlayers(){  //recuperer dans la fenetre choiceplayers
        return nbPlayers;
    }
}
