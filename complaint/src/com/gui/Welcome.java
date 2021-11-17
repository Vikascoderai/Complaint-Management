package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:/COREJAVA//complaint/src/com/images/customer-complaint-app-image.jpg"));
		setBackground(new Color(240, 240, 240));
		setForeground(new Color(0, 0, 0));
		createGui();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(9000);
					LoginFrame login=new LoginFrame();
					login.setVisible(true);
					Welcome.this.dispose();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	}
	public void createGui()
	{
		
		setTitle("Welcome Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrWelcomeToComplaint = new JTextArea();
		txtrWelcomeToComplaint.setForeground(Color.RED);
		txtrWelcomeToComplaint.setFont(new Font("Monotype Corsiva", Font.PLAIN, 22));
		txtrWelcomeToComplaint.setEditable(false);
		txtrWelcomeToComplaint.setText("welcome to complaint tracking system");
		txtrWelcomeToComplaint.setBounds(64, 80, 330, 40);
		contentPane.add(txtrWelcomeToComplaint);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setMaximumSize(new Dimension(1600, 1200));
		lblNewLabel.setMinimumSize(new Dimension(1000, 1000));
		lblNewLabel.setIcon(new ImageIcon("D://COREJAVA/complaint/src/com/images/customer-complaint-app-image.jpg"));
		lblNewLabel.setBounds(0, 0, 2200, 600);
		contentPane.add(lblNewLabel);
	}
}

