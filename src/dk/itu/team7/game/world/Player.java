package Gorilla;

import java.awt.Color;
/* import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel; */
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Player {
	
	private int x; 
    private int y; 
    private int width; 
    private int height; 
    private Color color;
    
	public Player (int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.width = 30;
		this.height = 30;
		this.color = c;
	}

	 public void display(Graphics g){
	        
	        // This is player rendered graphics.
	        Graphics2D graphics = (Graphics2D) g;    // Graphical library to render shapes.
	        graphics.setColor(color);
	        graphics.drawRect(x, y, width, height);
	        graphics.fillRect(x, y, width, height);
	        //graphics.
	    }

	    public void moveDown(){
	        
	        y = y + 20;
	    }
	    
	    /**
	     * Moves player up 20pixels
	     */
	    public void moveUp(){
	        
	         y = y - 20;
	    }



		
		// tegn spiller
	}


