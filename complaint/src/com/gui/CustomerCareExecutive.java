package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class CustomerCareExecutive extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCareExecutive frame = new CustomerCareExecutive();
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
	public CustomerCareExecutive() {
		setTitle("CustomerCareExecutive");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 672, 495);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 424, 21);
		contentPane.add(menuBar);
		
		JMenu mnComplain = new JMenu("Complain");
		mnComplain.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnComplain.setForeground(Color.MAGENTA);
		menuBar.add(mnComplain);
		
		JMenuItem mntmAddComplain = new JMenuItem("Add Complain");
		mntmAddComplain.addActionListener(this);
		mnComplain.add(mntmAddComplain);
		
		JMenuItem mntmA = new JMenuItem("Assign Complain");
		 mntmA.addActionListener(this);
		mnComplain.add(mntmA);
		
		JMenu mnViewComplaints = new JMenu("View complaints");
		mnViewComplaints.addActionListener(this);
		menuBar.add(mnViewComplaints);
		
		JMenuItem mntmByDate = new JMenuItem("by date");
		mntmByDate.addActionListener(this);
		mnViewComplaints.add(mntmByDate);
		
		JMenuItem mntmByCmpNo = new JMenuItem("by cmp no.");
		mntmByCmpNo.addActionListener(this);
		mnViewComplaints.add(mntmByCmpNo);
		
		JMenu mnTrackComplain = new JMenu("Track Complain");
		//mnTrackComplain.addActionListener(this);
		//mnTrackComplain.addActionListener(this);
		mnTrackComplain.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnTrackComplain.setForeground(Color.MAGENTA);
		menuBar.add(mnTrackComplain);
		
		JMenuItem mntmViewStatus = new JMenuItem("View Status");
		mntmViewStatus.addActionListener(this);
		mnTrackComplain.add(mntmViewStatus);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption=e.getActionCommand();
		if(caption.equalsIgnoreCase("by cmp no."))
			{
			ByCmp bc =new ByCmp();
			bc.setVisible(true);
			}
		if(caption.equalsIgnoreCase("Add Complain"))
		{
		Complain bc =new Complain();
		bc.setVisible(true);
		}	
		if(caption.equalsIgnoreCase("by date"))
		{
		ByDate bd =new ByDate();
		bd.setVisible(true);
		}	
		if(caption.equalsIgnoreCase("View Status"))
		{
		TrackComplain bd =new TrackComplain();
		bd.setVisible(true);
		}
		if(caption.equalsIgnoreCase("Assign Complain"))
		{
		AssignComplain bd =new AssignComplain();
		bd.setVisible(true);
		}
	}
}
