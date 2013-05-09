package dk.itu.team7.game;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_ENTER) {
			board.missedTarget = false;
			inputAngleField();
		}

		if (keyCode == KeyEvent.VK_SPACE) {
			board.isBanana1 = true;
			// board.setBanana1(true);
			// which is better?
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

		while (board.missedTarget == true) {
			missedTargetLabel.setVisible(true);
		}

		missedTargetLabel.setVisible(false);
	}
}