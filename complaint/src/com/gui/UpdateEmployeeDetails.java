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


public class UpdateEmployeeDetails extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtemail;
	private JTextField txtphone;
	 private JButton btnsearch,btnupdate;
	 private Connection cn;
	 private PreparedStatement psselect,psup;
      private ResultSet rs;
      private JLabel lblAddress;
      private JTextField txtaddress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployeeDetails frame = new UpdateEmployeeDetails();
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
	public UpdateEmployeeDetails() 
	{
		cn=CrudOperation.createConnection();
		createGui();
	}
	public  void createGui()
	{
		setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 487);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("Id");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblid.setBounds(42, 58, 46, 20);
		contentPane.add(lblid);
		
		txtid = new JTextField();
		txtid.setBounds(85, 61, 86, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		 btnsearch = new JButton("Search");
		 btnsearch.addActionListener(this);
		btnsearch.setBounds(197, 60, 89, 23);
		contentPane.add(btnsearch);
		
		JLabel lblemail = new JLabel("email");
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblemail.setBounds(25, 111, 46, 14);
		contentPane.add(lblemail);
		
		txtemail = new JTextField();
		txtemail.setBounds(85, 111, 185, 14);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblphone = new JLabel("phone");
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblphone.setBounds(25, 149, 63, 33);
		contentPane.add(lblphone);
		
		txtphone = new JTextField();
		txtphone.setBounds(99, 158, 133, 14);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		 btnupdate = new JButton("update");
		 btnupdate.addActionListener(this);
		btnupdate.setBounds(150, 285, 89, 23);
		contentPane.add(btnupdate);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(10, 193, 78, 33);
		contentPane.add(lblAddress);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(107, 201, 125, 20);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String pid=txtid.getText();
		
		String caption=e.getActionCommand();
		if(caption.equalsIgnoreCase("search"))
		{
			if(pid.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "enter id first");
			}
			else
			{
			try
			{
				String strsql="select * from employee where employeeid=?";
				psselect=cn.prepareStatement(strsql);
				psselect.setInt(1, Integer.parseInt(pid));
				rs=psselect.executeQuery();
				if(rs.next())
				{
					String em=rs.getString("email");
					String ph=rs.getString("phoneno");
					String ad=rs.getString("address");
					txtemail.setText(em);
					txtphone.setText(ph);
					txtaddress.setText(ad);
					txtid.setEditable(false);
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
		if(caption.equalsIgnoreCase("update"))
		{
			String id=txtid.getText();
			String em=txtemail.getText();
			String ph=txtphone.getText();
			String ad=txtaddress.getText();
			if(em.isEmpty()||ph.isEmpty()||ad.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "please fill all the details");  	
			}
			else
			{
				try
				{
					String strupdate="update employee set email=?,phoneno=?,address=? where employeeid=?";
					psup=cn.prepareStatement(strupdate);
					psup.setString(1, em);
					psup.setString(2, ph);
					psup.setString(3, ad);
					psup.setInt(4, Integer.parseInt(id));
				int rw=	psup.executeUpdate();
				if(rw>0)
				{
					
				JOptionPane.showMessageDialog(this, "added");  
				txtemail.setText("");
				txtphone.setText("");
				txtaddress.setText("");
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
