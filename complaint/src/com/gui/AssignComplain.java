package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;
//import com.mysql.jdbc.Connection;
import java.sql.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AssignComplain extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private Connection cn;
	private PreparedStatement ps;
	private JTextField textempid;
	private JTextField textcomplainid;
	private JTextField textstatus;
	private JTextField textremarks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignComplain frame = new AssignComplain();
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
	public AssignComplain() {
		cn=CrudOperation.createConnection();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeid = new JLabel("employeeid");
		lblEmployeeid.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblEmployeeid.setBounds(40, 65, 163, 46);
		contentPane.add(lblEmployeeid);
		
		textempid = new JTextField();
		textempid.setBounds(198, 81, 169, 20);
		contentPane.add(textempid);
		textempid.setColumns(10);
		
		JLabel lblComplaintid = new JLabel("complaintid");
		lblComplaintid.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblComplaintid.setBounds(40, 144, 114, 34);
		contentPane.add(lblComplaintid);
		
		textcomplainid = new JTextField();
		textcomplainid.setBounds(198, 154, 169, 20);
		contentPane.add(textcomplainid);
		textcomplainid.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblStatus.setBounds(53, 213, 101, 20);
		contentPane.add(lblStatus);
		
		textstatus = new JTextField();
		textstatus.setBounds(198, 216, 169, 20);
		contentPane.add(textstatus);
		textstatus.setColumns(10);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblRemarks.setBounds(65, 270, 75, 34);
		contentPane.add(lblRemarks);
		
		textremarks = new JTextField();
		textremarks.setBounds(198, 280, 169, 20);
		contentPane.add(textremarks);
		textremarks.setColumns(10);
		
		JButton btnSubmit = new JButton("submit");
		 btnSubmit.addActionListener(this);
		btnSubmit.setBounds(180, 349, 89, 23);
		contentPane.add(btnSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String empid=textempid.getText();
	
	String cmid=textcomplainid.getText();
	String status=textstatus.getText();

	String remarks=textremarks.getText();
	
	
	if(empid.isEmpty()||cmid.isEmpty()||status.isEmpty())
	{
		
		JOptionPane.showMessageDialog(this, "please fill all the details");
		
	}
	else
	{
		try {
			
		String str="insert into complaintracking(employeeid,complaintid,status,remarks) values (?,?,?,?)";
	  
		  ps=cn.prepareStatement(str);
		  ps.setString(1, empid);
		  ps.setString(2, cmid);
		  ps.setString(3, status);
		  ps.setString(4, remarks);
		  int rw=ps.executeUpdate();
		  if(rw>0)
		  {
			  JOptionPane.showMessageDialog(this, " record added");
				  
		  }
		   
	   }
	   catch(SQLException se)
	   {
		   System.out.println(se);
	   }
	}}}
	

