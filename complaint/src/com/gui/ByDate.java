package com.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dbutils.CrudOperation;

public class ByDate extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private PreparedStatement pscount,psdata;
	private ResultSet rscount,rsdata;
	private Connection cn;
	Object[][]data;
	String colnames[]={"complaintid","customerid","productname","complainttext","dateofcmp","status"};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewComplaints frame = new ViewComplaints();
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
  public ByDate() {
		// TODO Auto-generated constructor stub
	 
		cn=CrudOperation.createConnection();
		createGui();
		
	}
	
	public void createGui()
	
	
	{
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 804, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 50, 1200, 556);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(50);
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		fillData();
		table.setModel(new DefaultTableModel(
			data,
			colnames
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class,String.class,String.class,String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(166);
		table.getColumnModel().getColumn(1).setPreferredWidth(189);
		table.getColumnModel().getColumn(2).setPreferredWidth(88);
		table.getColumnModel().getColumn(3).setPreferredWidth(88);
		table.getColumnModel().getColumn(4).setPreferredWidth(88);
		table.getColumnModel().getColumn(5).setPreferredWidth(88);
		JTableHeader header = table.getTableHeader();
	      header.setBackground(Color.black);
	      header.setForeground(Color.white);
	      header.setFont(new Font("Arial", Font.BOLD, 20));
		table.setBorder(new LineBorder(Color.RED, 3));
		table.setFillsViewportHeight(true);
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		scrollPane.setViewportView(table);
	}
	
	
	 void fillData()
		{
		
	String strcount="select count(*) from complaint";
	

	try{
		pscount=cn.prepareStatement(strcount);
		
		rscount=pscount.executeQuery();
		rscount.next();
		int cnt=rscount.getInt(1);//2 records
		data=new Object[cnt][6];
		
	//String strdata="select * from course";
	
String strdata="select * from complaint order by dateofcmp desc";
	psdata=cn.prepareStatement(strdata);
	
	System.out.println(psdata);
	rsdata=psdata.executeQuery();
	int row=0;
	int flag=0;
	while(rsdata.next())
	{	flag=1;
		
		data[row][0]=rsdata.getString("complaintid");
		data[row][1]=rsdata.getString("customerid");
		data[row][2]=rsdata.getString("productname");
		data[row][3]=rsdata.getString("complaintext");
		data[row][4]=rsdata.getString("dateofcmp");
		data[row][5]=rsdata.getString("status");
		
		
		row++;
		
	}
	if(flag==0)
	{
		JOptionPane.showMessageDialog(this, "no  data present");
		
	}
		
	
		
		
	}
	catch(SQLException se)
	{
		System.out.println(se);
	}
		
		
			
			
			
		
}

	
	
	
}
