package com.gui;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class CompanyManager extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JMenuItem miaddemp,midelete,miupdateemp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyManager frame = new CompanyManager();
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
	public CompanyManager() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		createGui();
	}
	public  void createGui()
	{
		setTitle("CompanyManager\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEmplyee = new JMenu("Account");
		menuBar.add(mnEmplyee);
		
		 miaddemp = new JMenuItem("AddAcc");
		 miaddemp.addActionListener(this);
		mnEmplyee.add(miaddemp);
		
	 miupdateemp = new JMenuItem("UpdateAcc");
	 miupdateemp.addActionListener(this);
		mnEmplyee.add(miupdateemp);
		
		 midelete = new JMenuItem("DeleteAcc");
		 midelete.addActionListener(this);
		mnEmplyee.add(midelete);
		
		JButton btnViewComplaints = new JButton("View Complaints");
		btnViewComplaints.addActionListener(this);
		menuBar.add(btnViewComplaints);
		
		JMenuItem menuItem = new JMenuItem("");
		menuBar.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String caption=e.getActionCommand();
		if(caption.equalsIgnoreCase("addacc"))
			{
			EmployeeFrame pf =new EmployeeFrame();
			pf.setVisible(true);
			//this.dispose();
			}
		if(caption.equalsIgnoreCase("updateacc"))
		{
		UpdateEmployeeDetails pf =new UpdateEmployeeDetails();
		pf.setVisible(true);
		//this.dispose();
		}
		if(caption.equalsIgnoreCase("deleteacc"))
		{
		DeleteEmployeeDetails pf =new DeleteEmployeeDetails();
		pf.setVisible(true);
		}
		if(caption.equalsIgnoreCase("Add"))
		{
		Account pf =new Account();
		pf.setVisible(true);
		}
		if(caption.equalsIgnoreCase("view complaints"))
		{
		ViewComplaints pf =new ViewComplaints();
		pf.setVisible(true);
		}
		
	}
}
