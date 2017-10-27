import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView extends JFrame{

    private Deck deck;
    private Wargame game;
    private Card card1;
    private Card card2;

    public MainView(Deck deck){
        this.deck = deck;
        setTitle("The Game of War");
        game = new Wargame();
        game.deal();
        Container c = getContentPane();
        
///North Box (contains labels for the players and game status
        
        Box north = Box.createHorizontalBox();
        
        JLabel player1 = new JLabel("Player 1");
        JLabel gamestatus = new JLabel("Game Status");
        JLabel player2 = new JLabel("Player 2");
        
        north.add(Box.createHorizontalGlue());
        north.add(player1);
        north.add(Box.createRigidArea(new Dimension(205,0)));
        north.add(gamestatus);
        north.add(Box.createRigidArea(new Dimension(205,0)));
        north.add(player2);
        north.add(Box.createHorizontalGlue());
        
        c.add(north, BorderLayout.NORTH);
        
        
///Center Grid (contains the two players cards and the text area)       
        
        JPanel center = new JPanel(new GridLayout(1,3,5,5));
        CardPanel panel1 = new CardPanel();
        CardPanel panel2 = new CardPanel();
        JTextArea text1 = new JTextArea();
        center.add(panel1);
        center.add(text1);
        center.add(panel2);
        
        c.add(center, BorderLayout.CENTER);
      
///South Box (includes the two buttons)
        
        Box south = Box.createHorizontalBox();	                
        
        JButton button1 = new JButton("Move");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
        		if (! game.winner() == true) {	
        			game.move();
        			card1 = game.getCard1();
        			card2 = game.getCard2();
        			card1.turn();
        			card2.turn();
        			panel1.setCard(card1);
        			panel2.setCard(card2);
        			text1.setText(game.toString());
        		}
            }});
        
        JButton button2 = new JButton("New Game");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game = new Wargame();
        		game.deal();
        		card1 = null;
        		card2 = null;
        		panel1.setCard(card1);
    			panel2.setCard(card2);
    			text1.setText(game.toString());
        		
        		
             
                }
            });
    
        south.add(Box.createHorizontalGlue());
        south.add(button1);
        south.add(Box.createRigidArea(new Dimension(30,0)));
        south.add(button2);
        south.add(Box.createHorizontalGlue());
        c.add(south, BorderLayout.SOUTH);
    }
}
