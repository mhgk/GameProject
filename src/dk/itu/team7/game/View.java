package dk.itu.team7.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {

	/**
         *
         */
	private static final long serialVersionUID = 1L;

	/**
         *
         */

	final JLabel angleLabel = new JLabel("Enter angle:");
	final JTextField angleText = new JTextField();

	final static JLabel velocityLabel = new JLabel("Enter velocity:");
	final static JTextField velocityText = new JTextField();

	public void setupView() {

		//Board board = new Board();
		//board.setupBoard();

		//add(board);
		

		setSize(1366, 768);
		setTitle("Gorilla");
		setVisible(true); // make the frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default exit
														// action
		setResizable(false); // turn off resizing
		setLocationRelativeTo(null); // center the windows

		// inputAngleField();

	}
/*
	public void inputAngleField() {

		add(angleLabel);
		add(angleText);

		setLayout(null);

		angleLabel.setBounds(30, 20, 102, 20);
		angleText.setBounds(132, 20, 30, 20);

		angleText.requestFocus();

		angleText.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String inputAngle = angleText.getText();
				System.out.println(inputAngle);
				angleLabel.setVisible(false);
				angleText.setVisible(false);
				inputVelocityField();
				Double x = Double.parseDouble(inputAngle);
				Trajectory.inputAngle = x;
				
			}
		});
	}

	public void inputVelocityField() {

		add(velocityLabel);
		add(velocityText);

		setLayout(null);

		velocityLabel.setBounds(30, 20, 102, 20);
		velocityText.setBounds(132, 20, 30, 20);

		velocityText.requestFocus();

		velocityText.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String inputVelocity = velocityText.getText();
				System.out.println(inputVelocity);
				velocityLabel.setVisible(false);
				velocityText.setVisible(false);
				Double v = Double.parseDouble(inputVelocity);
				Trajectory.velocity = v;
				Trajectory.calculateDegree();
			}
		});
	}   */

	public View() {
	}
}