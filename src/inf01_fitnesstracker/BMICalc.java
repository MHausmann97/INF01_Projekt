/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf01_fitnesstracker;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author marle
 */
    
   



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class BMICalc extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextArea txtrWelcome;
	private JLabel lblName;
	private JTextField txtMeter;
	private JTextField txtCM;
	private JTextField txtWeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalc frame = new BMICalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BMICalc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(21, 101, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int m, cm, totalinches, weight;
				double bmi;
				// checking to make sure Name field has been entered.
				if (txtName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"You left the name blank.");
					txtName.grabFocus();
					return;
				}
				// Data Validation for Feet text box
				if (txtMeter.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"You left the feet field blank.");
					txtMeter.grabFocus();
					return;
				}
				if (isNumber(txtMeter.getText())) {
					feet = Integer.parseInt(txtMeter.getText());
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"Please enter feet as a number.");
					txtMeter.grabFocus();
					return;
				}
				// Data validation for inches (blank field will be 0)
				if (txtCM.getText().equals("")) {
					inches = 0;
					txtCM.setText("0");
				}
				else if (isNumber(txtCM.getText())) {
					inches = Integer.parseInt(txtCM.getText());
				}
				else {
					// user has non-number entered in inches
					JOptionPane.showMessageDialog(null, 
							"CM must be entered as a number.");
					txtCM.grabFocus();
					return;
				}
				// Data validation for weight
				if (txtWeight.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"You must enter your weight");
					txtWeight.grabFocus();
					return;
				}
				if (isNumber(txtWeight.getText())) {
					weight = Integer.parseInt(txtWeight.getText());
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"You must enter your weight as a whole number.");
					txtWeight.grabFocus();
					return;
				}
				// Calculate the BMI and produce the results
				
			}
		});
		btnNewButton.setBounds(99, 228, 89, 23);
		contentPane.add(btnNewButton);
		
		txtrWelcome = new JTextArea();
		txtrWelcome.setTabSize(8);
		txtrWelcome.setBackground(UIManager.getColor("Button.background"));
		txtrWelcome.setFont(new Font("Arial", Font.PLAIN, 12));
		txtrWelcome.setLineWrap(true);

		

		txtrWelcome.setText("Willkommen \r\n\r\nPlease provide your height  (in m and cm) and weight,\r\nand we'll let you know what your BMI (Body Mass Index) is.");

		txtrWelcome.setBounds(10, 11, 386, 78);
		contentPane.add(txtrWelcome);
		
		lblName = new JLabel("Name");
		lblName.setBounds(111, 104, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(21, 136, 46, 14);
		contentPane.add(lblHeight);
		
		txtMeter = new JTextField();
		txtMeter.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMeter.setBounds(71, 133, 46, 20);
		contentPane.add(txtMeter);
		txtMeter.setColumns(10);
		
		JLabel lblFt = new JLabel("m");
		lblFt.setBounds(121, 136, 12, 14);
		contentPane.add(lblFt);
		
		txtCM = new JTextField();
		txtCM.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCM.setColumns(10);
		txtCM.setBounds(139, 133, 46, 20);
		contentPane.add(txtCM);
		
		JLabel lblIn = new JLabel("cm");
		lblIn.setBounds(189, 136, 46, 14);
		contentPane.add(lblIn);
		
		JTextArea txtrResults = new JTextArea();
		txtrResults.setText("Results:");
		txtrResults.setTabSize(8);
		txtrResults.setLineWrap(true);
		txtrResults.setFont(new Font("Arial", Font.PLAIN, 12));
		txtrResults.setBackground(SystemColor.menu);
		txtrResults.setBounds(244, 139, 180, 78);
		contentPane.add(txtrResults);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(21, 164, 46, 14);
		contentPane.add(lblWeight);
		
		txtWeight = new JTextField();
		txtWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWeight.setColumns(10);
		txtWeight.setBounds(71, 161, 46, 20);
		contentPane.add(txtWeight);
		
		JLabel lblLb = new JLabel("kg");
		lblLb.setBounds(121, 164, 46, 14);
		contentPane.add(lblLb);
	}
	private static boolean isNumber(String n) {
		try {
			Integer.parseInt(n);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
}

    
