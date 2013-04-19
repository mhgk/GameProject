package dk.itu.team7.game;

import java.awt.Color;
/* import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel; */
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Player {
// this class defines what parameters we want to have on the players. Also we define what movement they can make.
	
	private int x; 
    private int y; 
    private int width; 
    private int height; 
    private Color color;
    
	public Player (int x, int y, int w, int h, Color c) {
// here we give the player its parameters
		
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.color = c;
	}

	public void display(Graphics g){
		// This method lets us draw the players
				 
			        // This is player rendered graphics.
			        Graphics2D graphics = (Graphics2D) g;    // Graphical library to render shapes.
			        graphics.setColor(color);
			        graphics.drawRect(x, y, width, height); // draws a rectangle circumces
			        graphics.fillRect(x, y, width, height); // this fills the rectangle with colour
			        //graphics.
			    }

	    public void moveDown(){
// this method indicates a movement-range when a key is pressed
	    	
	        y = y + 20;
	    }
	    
	    /**
	     * Moves player up 20pixels
	     */
	    public void moveUp(){
	        
	         y = y - 20;
	    }

 public int getY() {
	 
	 return y;
 }

 public int getX() {
	
	 return x;
	
	}

}