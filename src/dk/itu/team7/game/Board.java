package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener{
	/** This class calls on the player class and assign values to the player parameters.
	 * it also initialize the keylistner which takes input from the keyboard
	 */
	
	private static final long serialVersionUID = 1L;
	Player player1;
	Player player2;
    Banana banana;

    public Board() {
    	// makes 2 new player objects, and assign values to the player parameters
    	
    	player1 = new Player(50, 250, 40, 40, Color.blue); //(int x, int y, int w, int h, Color c)
    	player2 = new Player(710, 250, 40, 40, Color.red);
     //   banana = new Banana;
        
		addKeyListener(this);
    }
		
		
		 @Override
    	 public void keyTyped(KeyEvent e) {}

    	    @Override
    	    public void keyPressed(KeyEvent e) {
    	//this method calls on the method moveDown(in class player) to get the movement-range
    	    	
    	        int keyCode = e.getKeyCode();
    	         
    	         if (keyCode == KeyEvent.VK_S) {
    	             player1.moveDown();
    	         }
    	         
    	         if (keyCode == KeyEvent.VK_W) {
    	             player1.moveUp();
    	         }
      	         if (keyCode == KeyEvent.VK_DOWN) {
    	             player2.moveDown();
    	         }
    	         
    	         if (keyCode == KeyEvent.VK_UP) {
    	             player2.moveUp();
    	         }
    	    }

    	    @Override
    	    public void keyReleased(KeyEvent e) {}
    	    
    	    
    	    /**
    	     * Set's focus on the panel so key events are catch. 
    	     */
    	    
    	    public boolean isFocusTraversable() {
    	        return true;
    	   // what does this do?      
    	        
    	    }
    	    
    	    public void paint(Graphics g) {
    	    // This method lets us paint the new objects of the players. it calls on the method Graphics g in players.
    	    	
    	    	player1.display(g);
    	    	
    	    	player2.display(g);
    	    }
    	    
}
    		
		
/*
    //@Override
    public void paint(Graphics g) {

    	super.paint(g);
    	
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(50, 0, 100, 100); 
        g.setColor(Color.RED);
        //g.fillRect(0, 0, 100, 400);
        
        // g2d.drawRect(100, 100, 100, 100); 
        g.setColor(Color.RED);
        g.fillRect(100, 100, 100, 100);
        
        //Graphics2D g2d = (Graphics2D) g;
        // g2d.drawRect(200, 200, 100, 100); 
        g.setColor(Color.RED);
        g.fillRect(200, 200, 100, 100);
        
        // g2d.drawRect(300, 300, 100, 100); 
        g.setColor(Color.RED);
        g.fillRect(300, 300, 100, 100);
    }
}	
    	    
    	    */