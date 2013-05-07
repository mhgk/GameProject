package dk.itu.team7.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddInputVariabels extends JTextField {
	
	 
	private static final long serialVersionUID = 1L;
	final JLabel angleLabel = new JLabel("Enter angle:");
	final JTextField angleText = new JTextField();

	final JLabel velocityLabel = new JLabel("Enter velocity:");
	final JTextField velocityText = new JTextField();

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
				//angleLabel.setVisible(false);
				//angleText.setVisible(false);
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
	}
}
