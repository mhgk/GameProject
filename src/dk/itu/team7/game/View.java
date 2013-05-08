package dk.itu.team7.game;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class View extends JFrame implements KeyListener {
	private Board board;

	private static final long serialVersionUID = 1L;

	static final JLabel angleLabel = new JLabel("Enter angle:");
	static final JTextField angleText = new JTextField("");

	final static JLabel velocityLabel = new JLabel("Enter velocity:");
	final static JTextField velocityText = new JTextField();
	JLabel Player1 = new JLabel();
	JLabel Player2 = new JLabel();
    JLabel WindStrengt = new JLabel();
	// final static JLabel winner = new JLabel("Player2:" + "   " +
	// Board.counterP2);

	public View(Board board) {
		board.addKeyListener(this);
		this.board = board;
		add(board);

		// Board board = new Board();
		// board.setupBoard();

		// add(board);

		setSize(1366, 768);
		setTitle("Gorilla");
		setVisible(true); // make the frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default exit
		setResizable(false); // turn off resizing
		setLocationRelativeTo(null); // center the windows
		// inputAngleField();
		// showScore();
	}

	public void inputAngleField() {
		System.out.println("input virker?!");
		add(angleLabel);
		add(angleText);
		angleText.setText("");

		setLayout(null);

		angleLabel.setVisible(true);
		angleText.setVisible(true);

		angleLabel.setBounds(630, 20, 102, 20);
		angleText.setBounds(712, 20, 30, 20);

		angleText.requestFocus();

		angleText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String inputAngle = angleText.getText();
					Double ang = Double.parseDouble(inputAngle);
					Trajectory.setAngle(ang);
					angleLabel.setVisible(false);
					angleText.setVisible(false);

					inputVelocityField();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

		});
		repaint();

	}

	public void inputVelocityField() {

		add(velocityLabel);
		add(velocityText);
		velocityText.setText("");

		setLayout(null);
		velocityLabel.setVisible(true);
		velocityText.setVisible(true);

		velocityLabel.setBounds(630, 20, 102, 20);
		velocityText.setBounds(712, 20, 30, 20);

		velocityText.requestFocus();

		velocityText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String inputVelocity = velocityText.getText();
					System.out.println(inputVelocity);
					velocityLabel.setVisible(false);
					velocityText.setVisible(false);

					Double vel = Double.parseDouble(inputVelocity);
					Trajectory.velocity = vel;
				
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});

	}


	public void showScore() {
		Player1.setText("Player1:" + "   " + Board.getCounterP1());
		Player2.setText("Player2:" + "   " + Board.getCounterP2());
		WindStrengt.setText("WindStrengt:" + "   " + Trajectory.windFactor);
		add(Player1);
		add(Player2);
		add(WindStrengt);
		setLayout(null);
		Player1.setVisible(true);
		Player1.setBounds(35, 20, 102, 20);
		Player2.setVisible(true);
		Player2.setBounds(1260, 20, 102, 20);
		WindStrengt.setVisible(true);
		WindStrengt.setBounds(520, 20, 102, 20);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_ENTER) {

			inputAngleField();

		}

		if (keyCode == KeyEvent.VK_SPACE) {
			System.out.println("SPace");

			board.isBanana1 = true;

		}

		if (keyCode == KeyEvent.VK_CONTROL) {
		
			board.isBanana2 = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}