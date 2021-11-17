package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Account extends JFrame {

	private JPanel contentPane;
	private JTextField textaccid;
	private JTextField txtaccpass;
	private JTextField textrole;
	private JButton btnsubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account frame = new Account();
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
	public Account() {
		createGui();
		
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblaccountid = new JLabel("Accountid");
		lblaccountid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblaccountid.setBounds(28, 54, 77, 14);
		contentPane.add(lblaccountid);
		
		textaccid = new JTextField();
		textaccid.setBounds(129, 54, 86, 20);
		contentPane.add(textaccid);
		textaccid.setColumns(10);
		
		JLabel lblaccountpass = new JLabel("AccountPass\r\n");
		lblaccountpass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblaccountpass.setBounds(10, 90, 110, 34);
		contentPane.add(lblaccountpass);
		
		txtaccpass = new JTextField();
		txtaccpass.setBounds(129, 100, 86, 20);
		contentPane.add(txtaccpass);
		txtaccpass.setColumns(10);
		
		JLabel lblrole = new JLabel("Role\r\n");
		lblrole.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblrole.setBounds(28, 135, 66, 26);
		contentPane.add(lblrole);
		
		textrole = new JTextField();
		textrole.setBounds(129, 141, 86, 20);
		contentPane.add(textrole);
		textrole.setColumns(10);
		
		btnsubmit = new JButton("submit");
		btnsubmit.setBounds(126, 185, 89, 23);
		contentPane.add(btnsubmit);
	}
}
