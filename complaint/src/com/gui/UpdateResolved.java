package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;


public class UpdateResolved extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtphone;
	 private JButton btnsearch;
	 private Connection cn;
	 private PreparedStatement psselect,psup;
      private ResultSet rs;
      private JButton btnChange;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateResolved frame = new UpdateResolved();
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
	public UpdateResolved() 
	{
		cn=CrudOperation.createConnection();
		createGui();
	}
	public  void createGui()
	{
		setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 467);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("Enter ComplaintId");
		lblid.setForeground(Color.RED);
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblid.setBounds(25, 58, 168, 20);
		contentPane.add(lblid);
		
		txtid = new JTextField();
		txtid.setBounds(203, 61, 86, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		 btnsearch = new JButton("Search Status");
		 btnsearch.addActionListener(this);
		btnsearch.setBounds(132, 106, 134, 33);
		contentPane.add(btnsearch);
		
		JLabel lblphone = new JLabel("CurrentStatus");
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblphone.setBounds(25, 176, 131, 33);
		contentPane.add(lblphone);
		
		txtphone = new JTextField();
		txtphone.setBounds(201, 182, 133, 20);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		btnChange = new JButton("Change");
		btnChange.addActionListener(this);
		btnChange.setBounds(132, 234, 89, 23);
		contentPane.add(btnChange);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String pid=txtid.getText();
		
		String caption=e.getActionCommand();
		if(caption.equalsIgnoreCase("search status"))
		{
			if(pid.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "enter id first");
			}
			else
			{
			try
			{
				String strsql="select * from complaint where complaintid=?";
				psselect=cn.prepareStatement(strsql);
				psselect.setInt(1, Integer.parseInt(pid));
				rs=psselect.executeQuery();
				if(rs.next())
				{
					String em=rs.getString("Status");
					
					txtphone.setText(em);
					//txtid.setEditable(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "noo such record ");
				}
				
			}
			catch( SQLException se)
			{
				System.out.println(se);
			}
			}
		}
		if(caption.equalsIgnoreCase("change"))
		{
			String id=txtid.getText();
			String st=txtphone.getText();
			
			if(id.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "please fill all the details");  	
			}
			else
			{
				try
				{
					String strupdate="update complaint set status=? where complaintid=?";
					psup=cn.prepareStatement(strupdate);
					psup.setString(1, st);
					
					psup.setString(2, id);
				int rw=	psup.executeUpdate();
				if(rw>0)
				{
					
				JOptionPane.showMessageDialog(this, "added");  
				
				}
					
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			}
			
			
		}
		
		
	}
}
