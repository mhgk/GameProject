package dk.itu.team7.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class View extends JFrame implements KeyListener {
	private Board board;

	private static final long serialVersionUID = 1L;

	final JLabel angleLabel = new JLabel("Enter angle:");
	final JTextField angleText = new JTextField();

	final static JLabel velocityLabel = new JLabel("Enter velocity:");
	final static JTextField velocityText = new JTextField();
	int sp1;
	int sp2;
	  JLabel Player1 = new JLabel();
	  JLabel Player2 = new JLabel("Player2:" + "   " + Board.getCounterP2());
	// final static JLabel winner = new JLabel("Player2:" + "   " + Board.counterP2);
	
	public View(Board board) {
		board.addKeyListener(this);
		this.board = board;
		add(board);
		

		//Board board = new Board();
		//board.setupBoard();

		//add(board);
		

		setSize(1366, 768);
		setTitle("Gorilla");
		setVisible(true); // make the frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default exit
		setResizable(false); // turn off resizing
		setLocationRelativeTo(null); // center the windows
		// inputAngleField();
	//	 showScore();
	}
	
	

	public void inputAngleField() {
	
		add(angleLabel);
		add(angleText);

		setLayout(null);
		
		angleLabel.setVisible(true);
		angleText.setVisible(true);

		angleLabel.setBounds(650, 20, 102, 20);
		angleText.setBounds(782, 20, 30, 20);

		angleText.requestFocus();

		angleText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					String inputAngle = angleText.getText();
					
					angleLabel.setVisible(false);
					angleText.setVisible(false);
					repaint();
					Double ang = Double.parseDouble(inputAngle);
					Trajectory.setAngle(ang);
					inputVelocityField();  
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}); 
	}

	public void inputVelocityField() {

		add(velocityLabel);
		add(velocityText);
        
		setLayout(null);
		
		velocityLabel.setVisible(true);
		velocityText.setVisible(true);

		velocityLabel.setBounds(650, 20, 102, 20);
		velocityText.setBounds(782, 20, 30, 20);

		velocityText.requestFocus();

		velocityText.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String inputVelocity = velocityText.getText();
				System.out.println(inputVelocity);
				velocityLabel.setVisible(false);
				velocityText.setVisible(false);
				Double vel = Double.parseDouble(inputVelocity);
				Trajectory.velocity = vel;
				//Trajectory.calculateDegree();
				board.isBanana1 = true;
			}
		});
	}   
	
	public void showScore(){
		Player1.setText("Player1:" + "   " + Board.getCounterP1());
		add(Player1);
		add(Player2);
		setLayout(null);
		Player1.setVisible(true);
		Player1.setBounds(35, 20, 102, 20);
		Player2.setVisible(true);
		Player2.setBounds(1260, 20, 102, 20);

	}
	
	/*
	public void showWinner(){
		add(winner);
		winner.setVisible(true);
		winner.setBounds(200, 20, 102, 20);
	} */

	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_SPACE) {
		System.out.println("SPace");
			inputAngleField();
			
			
			
		//	board.isBanana1 = true;
			
		}
		
		if (keyCode == KeyEvent.VK_CONTROL) {
			// inputVelocityField();
		//	board.isBanana2 = true;
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}