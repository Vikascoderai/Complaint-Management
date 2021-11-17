package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.Connection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import com.dbutils.CrudOperation;


public class Complain extends JFrame  implements ActionListener
{

	private JPanel contentPane;
	private JTextField textcustomerid;
	private JTextField textname;
	private JTextField textaddress;
	private JTextField textphoneno;
	private JTextField textemail;
	private JTextField textcomplaintid;
	private JTextField textproductname;
	private JTextField textcomplaintext;
	private  static Connection cn;
	private static PreparedStatement ps,ps1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Complain frame = new Complain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void  createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 817, 490);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerid = new JLabel("Customerid");
		lblCustomerid.setForeground(Color.BLUE);
		lblCustomerid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCustomerid.setBounds(68, 62, 116, 26);
		contentPane.add(lblCustomerid);
		
		textcustomerid = new JTextField();
		textcustomerid.setBounds(226, 67, 147, 20);
		contentPane.add(textcustomerid);
		textcustomerid.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setForeground(Color.BLUE);
		lblName.setBounds(78, 99, 86, 26);
		contentPane.add(lblName);
		
		textname = new JTextField();
		textname.setBounds(226, 104, 147, 20);
		contentPane.add(textname);
		textname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setForeground(Color.BLUE);
		lblAddress.setBounds(68, 136, 86, 26);
		contentPane.add(lblAddress);
		
		textaddress = new JTextField();
		textaddress.setBounds(223, 141, 150, 20);
		contentPane.add(textaddress);
		textaddress.setColumns(10);
		
		JLabel lblPhoneno = new JLabel("phoneno");
		lblPhoneno.setForeground(Color.BLUE);
		lblPhoneno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneno.setBounds(68, 160, 109, 34);
		contentPane.add(lblPhoneno);
		
		textphoneno = new JTextField();
		textphoneno.setBounds(226, 172, 147, 20);
		contentPane.add(textphoneno);
		textphoneno.setColumns(10);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(68, 205, 86, 20);
		contentPane.add(lblEmail);
		
		textemail = new JTextField();
		textemail.setBounds(225, 207, 148, 20);
		contentPane.add(textemail);
		textemail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("complaintid");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setBounds(68, 249, 86, 26);
		contentPane.add(lblNewLabel);
		
		textcomplaintid = new JTextField();
		textcomplaintid.setBounds(226, 255, 147, 20);
		contentPane.add(textcomplaintid);
		textcomplaintid.setColumns(10);
		
		JLabel lblProductname = new JLabel("productname");
		lblProductname.setForeground(Color.BLUE);
		lblProductname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductname.setBounds(55, 303, 109, 26);
		contentPane.add(lblProductname);
		
		textproductname = new JTextField();
		textproductname.setBounds(226, 308, 147, 20);
		contentPane.add(textproductname);
		textproductname.setColumns(10);
		
		JLabel lblComplaintext = new JLabel("Complaintext");
		lblComplaintext.setForeground(Color.BLUE);
		lblComplaintext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblComplaintext.setBounds(42, 353, 112, 26);
		contentPane.add(lblComplaintext);
		
		textcomplaintext = new JTextField();
		textcomplaintext.setBounds(226, 358, 352, 20);
		contentPane.add(textcomplaintext);
		textcomplaintext.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		 btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(165, 407, 133, 34);
		contentPane.add(btnNewButton);
	}

	/**
	 * Create the frame.
	 */
	public Complain() 
	{
	   createGui();
		cn=CrudOperation.createConnection();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	   int rw=0,row=0;
		String cid=textcustomerid.getText();
		String name=textname.getText();
		String address=textaddress.getText();
		String phone=textphoneno.getText();
		String email=textemail.getText();
		String cmid=textcomplaintid.getText();
		String pname=textproductname.getText();
		String ctext=textcomplaintext.getText();
		java.util.Date sysdate=new java.util.Date();
		java.sql.Date sysdt=new java.sql.Date(sysdate.getTime());
		//String ci=textcustomerid.getText();
		if(cid.isEmpty()||address.isEmpty()||phone.isEmpty()||email.isEmpty()||name.isEmpty()||cmid.isEmpty()||pname.isEmpty()||ctext.isEmpty())
		{
			
			JOptionPane.showMessageDialog(this, "please fill all the details");
			
		}
		else
		{
			try {
				cn.setAutoCommit(false);
				String strinsert="insert into customer  values (?,?,?,?,?)";
				ps=cn.prepareStatement(strinsert);//dbms parser
				ps.setString(1, cid);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setString(4, phone);
				ps.setString(5, email);
				
			  
			 row=ps.executeUpdate();
			}
			catch(SQLException se)
			{
				System.out.println(se);
				
			}
			try 
			{
			String str="insert into complaint (complaintid,customerid,productname,complaintext,dateofcmp) values (?,?,?,?,?)";
			ps1=cn.prepareStatement(str);
			ps1.setString(1, cmid);
			ps1.setString(2, cid);
			ps1.setString(3, pname);
			ps1.setString(4, ctext);
			ps1.setDate(5, sysdt);
			rw=ps1.executeUpdate();
			
			}
			catch(SQLException se)
			{
				System.out.println(se);
				
			}
			//insert update delete 
			if(row>0&&rw>0)
			{
			try {
				cn.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			JOptionPane.showMessageDialog(this, "record added");
			textname.setText("");
			textphoneno.setText("");
			textemail.setText("");
			textcustomerid.setText("");
			textcomplaintid.setText("");
			textproductname.setText("");
			textaddress.setText("");
			textcomplaintext.setText("");
			}
			
			
		
	}
}}
