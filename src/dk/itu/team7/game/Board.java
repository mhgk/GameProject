package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener{
	/** This class calls on the player class and assign values to the player parameters.
	 * it also initialize the keyListener which takes input from the keyboard
	 */
	
	private static final long serialVersionUID = 1L;
	Player player1;
	Player player2;
    Banana banana1;
    boolean isBanana = false;
    

    public Board() {
    	// makes 2 new player objects, and assign values to the player parameters
    	
    	player1 = new Player(randomX()+10, 450-randomY(), 20, 40, Color.blue); //(int x, int y, int w, int h, Color c)
    	player2 = new Player(790-randomX(), 450-randomY(), 20, 40, Color.red);
    	banana1 = new Banana(player1.getX(), player1.getY(), 20, 20, Color.YELLOW);
    	//banana = new Banana(x, y, w, h, Color.YELLOW);
        
		addKeyListener(this);
    }
		
		
		 @Override
    	 public void keyTyped(KeyEvent e) {}

    	    @Override
    	    public void keyPressed(KeyEvent e) {
    	//this method calls on the method moveDown(in class player) to get the movement-range
    	    	
    	        int keyCode = e.getKeyCode();
    	         
    /*	         if (keyCode == KeyEvent.VK_S) {
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
    	         
    	         */    	        
    	        
    	         if (keyCode == KeyEvent.VK_SPACE) {
    	            	        	 
    	        	 
    	        	isBanana = true;
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
    	    	
    	    	if (isBanana) {
    	    		for (int i = 0; i < 1200; i++) {
    	    			banana1.projectory();
    	    			
    	    			banana1.display(g);
    	    	       
    	    		}
    	    		
    	    		banana1.updateBanana(player1.getX(), player1.getY());
    	    			 
    	    	isBanana = false;
    	    	
    	    	    	    		
    	    	}
    	    	
    	    	
    	    }
    
   public int randomX() {
	   
	   Random randomStartPosX = new Random();
	   
	   int x =  randomStartPosX.nextInt(190);
	    
	   return x;
	   
	   
   }
    
   public int randomY() {
	   
	   Random randomStartPosY = new Random();
	  
	   int y = randomStartPosY.nextInt(190);
	    
	    return y;
   }
}
    		