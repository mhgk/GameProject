package dk.itu.team7.game;


import javax.swing.*;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public void setupView () {
		 
		Board board = new Board();
		
		add(board);
		setSize(1366, 768);
		setTitle("Gorilla");
		setVisible(true); // make the frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default exit action
		setResizable(false); // turn off resizing
		setLocationRelativeTo(null); // center the windows
	}
	
	public View() {
		// TODO Auto-generated constructor stub
	}

}
