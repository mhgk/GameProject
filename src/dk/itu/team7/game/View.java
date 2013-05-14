package dk.itu.team7.game;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class creates the JFrame, which contains the JPanel, JLabels and
 * JTextFields. It also implements the KeyListener, which listens for keyboard
 * events.
 * 
 * @author Team 7: Mads Gade & Rene A. Nielsen
 * @version 1.0
 * 
 * 
 */

public class View extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	private Board board;

	JLabel angleLabel = new JLabel("Enter angle:");
	JTextField angleText = new JTextField("");

	JLabel velocityLabel = new JLabel("Enter velocity:");
	JTextField velocityText = new JTextField();

	JLabel player1Label = new JLabel();
	JLabel player2Label = new JLabel();
	JLabel windFactorLabel = new JLabel();
	JLabel missedTargetLabel = new JLabel();

	/**
	 * This creates View with Board as parameter which is added View. It also
	 * sets the properties of the JFrame.
	 * 
	 * @param board
	 *            Board from GameRunner is used in View and added to JFrame.
	 */

	public View(Board board) {
		board.addKeyListener(this);
		this.board = board;
		add(board);

		setSize(1366, 768);
		setTitle("Gorilla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default exit
		setResizable(false); // turn off resizing
		setLocationRelativeTo(null); // center the windows
		setVisible(true); // make the frame visible

	}

	/**
	 * This method controls what happens, when a keyboard button is pressed.
	 * <p>
	 * Enter shows the angle input field and starts listening for input
	 * <p>
	 * Space throws the banana for player 1
	 * <p>
	 * Control throws the banana for player 2
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_ENTER) {
			inputAngleField();
		}

		if (keyCode == KeyEvent.VK_SPACE) {
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

	/**
	 * This method sets the properties of the angle textfield. It listens for
	 * angle input, and saves this in Trajectory. When angle input is saved,
	 * visibility of the textfield is set to false and inputVelocityField() is
	 * called.
	 */

	public void inputAngleField() {

		setLayout(null);

		angleText.setText("");

		angleLabel.setBounds(610, 20, 102, 20);
		angleText.setBounds(712, 20, 30, 20);

		add(angleLabel);
		add(angleText);

		angleLabel.setVisible(true);
		angleText.setVisible(true);

		angleText.requestFocus();

		angleText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String inputAngle = angleText.getText();

					Double ang = null;
					try {
						ang = Double.parseDouble(inputAngle);
					} catch (NumberFormatException e) {
						ang = 0.0;
					}

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

	/**
	 * This method sets the properties of the velocity textfield. It listens for
	 * velocity input, and saves this in Trajectory. When velocity input is
	 * saved, visibility of the textfield is set to false.
	 */

	public void inputVelocityField() {

		setLayout(null);

		velocityText.setText("");

		velocityLabel.setBounds(610, 20, 102, 20);
		velocityText.setBounds(712, 20, 30, 20);

		add(velocityLabel);
		add(velocityText);

		velocityLabel.setVisible(true);
		velocityText.setVisible(true);

		velocityText.requestFocus();

		velocityText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String inputVelocity = velocityText.getText();
					velocityLabel.setVisible(false);
					velocityText.setVisible(false);

					Double vel = null;
					try {
						vel = Double.parseDouble(inputVelocity);
					} catch (Exception e) {
						vel = 0.0;
					}
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

	/**
	 * This method shows the score for each player and the wind factor for the
	 * map. When a player shoots a banana out of bounds a 'missed target' label
	 * is displayed for 5 seconds.
	 */

	public void showScore() {

		setLayout(null);

		player1Label.setText("Player1:  " + Board.getCounterP1());
		player2Label.setText("Player2:  " + Board.getCounterP2());
		windFactorLabel.setText("WindStrength:  " + Trajectory.windFactor);
		missedTargetLabel.setText("You missed!");

		player1Label.setBounds(35, 20, 102, 20);
		player2Label.setBounds(1260, 20, 102, 20);
		windFactorLabel.setBounds(450, 20, 200, 20);
		missedTargetLabel.setBounds(600, 200, 200, 50);

		add(player1Label);
		add(player2Label);
		add(windFactorLabel);
		add(missedTargetLabel);

		player1Label.setVisible(true);
		player2Label.setVisible(true);
		windFactorLabel.setVisible(true);
		missedTargetLabel.setVisible(false);

		if (board.missedTarget == true) {

			missedTargetLabel.setVisible(true);

			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					board.missedTarget = false;
				}
			}, 5000);
		}
	}
}