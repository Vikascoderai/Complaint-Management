package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class TrackComplain extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static Connection cn;
	private static PreparedStatement psselect;
	private static ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackComplain frame = new TrackComplain();
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
	public TrackComplain() {
		cn=CrudOperation.createConnection();
		setTitle("Track Complains\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterComplaintid = new JLabel("Enter Complaintid");
		lblEnterComplaintid.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterComplaintid.setForeground(Color.BLUE);
		lblEnterComplaintid.setBounds(39, 81, 182, 35);
		contentPane.add(lblEnterComplaintid);
		
		textField = new JTextField();
		textField.setBounds(231, 91, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(159, 127, 89, 23);
		contentPane.add(btnSearch);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 198, 128, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatus.setBounds(86, 188, 71, 35);
		contentPane.add(lblStatus);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
String pid=textField.getText();
		
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
				String strsql="select * from complaint where complaintid=?";
				psselect=cn.prepareStatement(strsql);
				psselect.setInt(1, Integer.parseInt(pid));
				rs=psselect.executeQuery();
				if(rs.next())
				{
					String em=rs.getString("status");
					//String ph=rs.getString("phoneno");
					//String ad=rs.getString("address");
					textField_1.setText(em);
					/*txtphone.setText(ph);
					txtaddress.setText(ad);
					txtid.setEditable(false);*/
				}
				else
				{
					JOptionPane.showMessageDialog(this, "noo such record ");
					textField_1.setText("");
				}
				
			}
			catch( SQLException se)
			{
				System.out.println(se);
			}
			}
		}
		// TODO Auto-generated method stub
		
	}
}
