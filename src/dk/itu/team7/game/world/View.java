package Gorilla;


import javax.swing.*;

public class View extends JFrame {

	/**
	 * 
	 */
	public View() {

		add(new Board());
		setSize(800, 600);
		setTitle("Gorilla");
		setVisible(true); // make the frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default exit action
		setResizable(false); // turn off resizing
		setLocationRelativeTo(null); // center the windows
	}
	public static void main(String[] args) {
		new View();	
	}
}