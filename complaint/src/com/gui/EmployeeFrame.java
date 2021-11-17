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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.sql.*;

public class EmployeeFrame extends JFrame  implements ActionListener
{

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textemail;
	private JTextField textphone;
	private static  Connection cn;
	private static PreparedStatement ps,ps1;
	private JTextField textaddress;
	private JTextField textempid;
	private JTextField textemppass;
	private JTextField textrole;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
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
	public EmployeeFrame() {
		createGui();
		cn=CrudOperation.createConnection();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 646, 473);
		
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblname = new JLabel("Name");
		lblname.setForeground(Color.RED);
		lblname.setFont(new Font("Courier New", Font.BOLD, 18));
		lblname.setBackground(Color.CYAN);
		lblname.setBounds(57, 147, 92, 27);
		contentPane.add(lblname);
		
		textname = new JTextField();
		textname.setFont(new Font("Courier New", Font.BOLD, 18));
		textname.setBounds(159, 150, 169, 20);
		contentPane.add(textname);
		textname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.RED);
		lblEmail.setFont(new Font("Courier New", Font.BOLD, 18));
		lblEmail.setBounds(58, 237, 91, 27);
		contentPane.add(lblEmail);
		
		textemail = new JTextField();
		textemail.setFont(new Font("Courier New", Font.BOLD, 18));
		textemail.setBounds(174, 240, 169, 20);
		contentPane.add(textemail);
		textemail.setColumns(10);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setForeground(Color.RED);
		lblphone.setFont(new Font("Courier New", Font.BOLD, 18));
		lblphone.setBounds(57, 293, 92, 20);
		contentPane.add(lblphone);
		
		textphone = new JTextField();
		textphone.setFont(new Font("Courier New", Font.BOLD, 18));
		textphone.setBounds(174, 293, 154, 20);
		contentPane.add(textphone);
		textphone.setColumns(10);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(this);
		btnsubmit.setFont(new Font("Courier New", Font.BOLD, 18));
		btnsubmit.setForeground(Color.BLUE);
		btnsubmit.setBounds(208, 348, 120, 41);
		contentPane.add(btnsubmit);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setForeground(Color.RED);
		lbladdress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbladdress.setBackground(Color.RED);
		lbladdress.setBounds(39, 185, 113, 41);
		contentPane.add(lbladdress);
		
		textaddress = new JTextField();
		textaddress.setBounds(159, 197, 192, 20);
		contentPane.add(textaddress);
		textaddress.setColumns(10);
		
		JLabel lblEmpid = new JLabel("EmpId");
		lblEmpid.setForeground(Color.RED);
		lblEmpid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmpid.setBounds(57, 29, 86, 27);
		contentPane.add(lblEmpid);
		
		textempid = new JTextField();
		textempid.setBounds(159, 34, 154, 20);
		contentPane.add(textempid);
		textempid.setColumns(10);
		
		JLabel lblEmppass = new JLabel("EmpPass");
		lblEmppass.setForeground(Color.RED);
		lblEmppass.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmppass.setBounds(51, 70, 92, 27);
		contentPane.add(lblEmppass);
		
		textemppass = new JTextField();
		textemppass.setBounds(159, 75, 154, 20);
		contentPane.add(textemppass);
		textemppass.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setForeground(Color.RED);
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRole.setBounds(61, 110, 60, 26);
		contentPane.add(lblRole);
		
		textrole = new JTextField();
		textrole.setBounds(159, 119, 154, 20);
		contentPane.add(textrole);
		textrole.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int rw=0,row=0;
		String name=textname.getText();
		String email=textemail.getText();
		String phone=textphone.getText();

		String empid=textempid.getText();
		String emppass=textemppass.getText();
		String role=textrole.getText();

		String address=textaddress.getText();
		
		if(name.isEmpty()||address.isEmpty()||phone.isEmpty()||email.isEmpty()||empid.isEmpty()||emppass.isEmpty()||role.isEmpty())
		{
			
			JOptionPane.showMessageDialog(this, "please fill all the details");
			
		}
		else
		{
			try {
				cn.setAutoCommit(false);
				String strinsert="insert into Employee(employeeid,name,address ,phoneno,email) values (?,?,?,?,?)";
				ps=cn.prepareStatement(strinsert);//dbms parser
				ps.setString(1, empid);
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
			String str="insert into login values (?,?,?)";
			ps1=cn.prepareStatement(str);
			ps1.setString(1, empid);
			ps1.setString(2, emppass);
			ps1.setString(3, role);
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
			textphone.setText("");
			textemail.setText("");
			textrole.setText("");
			textempid.setText("");
			textemppass.setText("");
			textaddress.setText("");
			}
			
			
			
			/*
			finally
			{
				if(ps!=null&&ps1!=null)
					try {
						ps.close();
						ps1.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			*/
			
		}
		// TODO Auto-generated method stub
		
	}}

