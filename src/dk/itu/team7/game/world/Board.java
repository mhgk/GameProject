package Gorilla;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener{
	
	Player player1;
	Player player2;


    public Board() {
    	
    	player1 = new Player(50, 300, 40, 40, Color.blue);
    	player2 = new Player(750, 300, 40, 40, Color.red);
  
		addKeyListener(this);
    }
		
		
		 @Override
    	 public void keyTyped(KeyEvent e) {}

    	    @Override
    	    public void keyPressed(KeyEvent e) {
    	        
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
    	    }

    		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//      ImageIcon ii = new ImageIcon(this.getClass().getResource("bardejov.png"));
//        bardejov = ii.getImage();
    	
//    	int square.height = 
  //  	int square.width = 
    }

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