package com.gui;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.dbutils.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.*;
public class LoginFrame extends JFrame  implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtuserid;
	private JPasswordField txtuserpass;
	private JButton btnsubmit;
	private Connection cn;
	private PreparedStatement pslogin;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(
				new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setBackground(Color.PINK);
		setTitle("Login");
		cn=CrudOperation.createConnection();
		
		createGui();
		
	}
	
	public void createGui()
	{
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 883, 735);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new LineBorder(Color.BLUE, 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblname = new JLabel("Enter  UserId");
		lblname.setForeground(Color.RED);
		lblname.setFont(new Font("Comic Sans MS", Font.PLAIN, 29));
		lblname.setBounds(73, 91, 219, 43);
		contentPane.add(lblname);
		
		txtuserid = new JTextField();
		txtuserid.setBounds(307, 97, 261, 43);
		contentPane.add(txtuserid);
		txtuserid.setColumns(10);
		JLabel lblUserpass = new JLabel("UserPass");
		lblUserpass.setForeground(Color.RED);
		lblUserpass.setFont(new Font("Comic Sans MS", Font.PLAIN, 29));
		
		lblUserpass.setBounds(73, 207, 145, 43);
		contentPane.add(lblUserpass);
		
		txtuserpass = new JPasswordField();
		txtuserpass.setBounds(293, 204, 278, 26);
		contentPane.add(txtuserpass);
		
		btnsubmit = new JButton("submit");
		btnsubmit.addActionListener(this);
		
		btnsubmit.setBounds(293, 338, 115, 29);
		contentPane.add(btnsubmit);
	}
	public String checkUserDetails(String userid,String userpass)
	{
		try {
	String strsql="select * from login where userid=? and userpass=?";
	
		pslogin=cn.prepareStatement(strsql);
		
		pslogin.setString(1,userid);
		pslogin.setString(2, userpass);
		rs=pslogin.executeQuery();
		if(rs.next())
		{
			String type=rs.getString("usertype");
			return type;
		}
			
			
	
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
			
		}
		return "invalid userid/password";
		
		
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String ui=txtuserid.getText();
		char[]arr=txtuserpass.getPassword();
		String upass=new String(arr);
		
	if(ui.trim().length()==0||upass.isEmpty())
		{
			
		JOptionPane.showMessageDialog(this,"userid/password needed");		
			
		}
	else {
			String info=checkUserDetails(ui, upass);
			
			
			if(info.equalsIgnoreCase("companymanager"))
			{
		CompanyManager ad=new CompanyManager();
				ad.setVisible(true);
				//this.dispose();
			}
			
			else if(info.equalsIgnoreCase("service engineer"))
			{
				ServiceEngineer ck=new ServiceEngineer();
				ck.setVisible(true);
				//this.dispose();
			}
			else if(info.equalsIgnoreCase("cce"))
			{
				CustomerCareExecutive ck=new CustomerCareExecutive();
				ck.setVisible(true);
				//this.dispose();
			}
	
			
		
		else {
			JOptionPane.showMessageDialog(this,info);
			
		}
	}
		
		
		
	}
	
	
	
	
	
	
}
