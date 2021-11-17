package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ServiceEngineer extends JFrame implements ActionListener,WindowListener

{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceEngineer frame = new ServiceEngineer();
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
	public ServiceEngineer() {
		setTitle("Service Engineer\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 512);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnViewComplains = new JMenu("View Complains");
		menuBar.add(mnViewComplains);
		
		JMenuItem mntmAssignedComplains = new JMenuItem("Assigned Complains");
		mntmAssignedComplains.addActionListener(this);
		mnViewComplains.add(mntmAssignedComplains);
		
		JMenu mnResolveComplains = new JMenu("Resolve Complains");
		menuBar.add(mnResolveComplains);
		
		JMenuItem mntmResolve = new JMenuItem("UpdateResolved");
		mntmResolve.addActionListener(this);
		mnResolveComplains.add(mntmResolve);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{

		String caption=e.getActionCommand();
		if(caption.equalsIgnoreCase("Assigned Complains"))
			{
		           AssignedComplains pf =new AssignedComplains();
			pf.setVisible(true);
			}
		if(caption.equalsIgnoreCase("updateresolved"))
		{
	        UpdateResolved pf =new UpdateResolved();
		pf.setVisible(true);
		//this.dispose();
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) 
	{
		// TODO Auto-generated method stub
			
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
		
		
	}

