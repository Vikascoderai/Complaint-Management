 package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.sql.*;
public class DeleteEmployeeDetails extends JFrame  implements ActionListener
{

	private JPanel contentPane;
	private Connection cn;
	private PreparedStatement pscombo,psdelete;
	private ResultSet rs;
	JComboBox cmbid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployeeDetails frame = new DeleteEmployeeDetails();
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
	public DeleteEmployeeDetails() 
	{
		cn=CrudOperation.createConnection();
		creatGui();
	}
	public void fillcombo()
	{
		try
		{
		String strsql="select employeeid,name from employee"	;
		pscombo=cn.prepareStatement(strsql);
		rs=pscombo.executeQuery();
		while(rs.next())
		{
			String pid=rs.getString("employeeid");
			cmbid.addItem(pid);
		}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	public void creatGui() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 617, 526);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Employee");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btndelete = new JButton("DELETE");
		btndelete.addActionListener(this);
		btndelete.setBounds(157, 177, 89, 23);
		contentPane.add(btndelete);
		
		cmbid=new JComboBox();
				
				cmbid.setModel(new DefaultComboBoxModel<>(new String[] {"select Person Id"}));
		fillcombo();
		cmbid.setBounds(157, 119, 132, 31);
		contentPane.add(cmbid);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	String cid=	(String)cmbid.getSelectedItem();
	if(cid.equalsIgnoreCase("select employee Id"))
	{
		JOptionPane.showMessageDialog(this, "please select", "info",JOptionPane.INFORMATION_MESSAGE);
	}
	else
	{
		
		int confirm=JOptionPane.showConfirmDialog(this, "are you sure");
	   System.out.println(confirm);
	   if(confirm==0)
	   {
		   try
		   {
			   String strdelete="delete from employee where employeeid=? ";
			   psdelete=cn.prepareStatement(strdelete);
			   psdelete.setInt(1, Integer.parseInt(cid));
			   int rw=psdelete.executeUpdate();
			   if(rw>0)
			   {
				   
				  
				   JOptionPane.showMessageDialog(this, "record delete successfully");
			        cmbid.removeAllItems();
				   cmbid.addItem("select Person Id");
				   fillcombo();
			   }
			   
		   }
		   catch(SQLException se)
		   {
			 System.out.println(se);  
		   }
	   }
	}
	
	
		
		// TODO Auto-generated method stub
		
	}

}
