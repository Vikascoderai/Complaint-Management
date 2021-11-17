package com.dbutils;
import java.sql.*;

public class CrudOperation
{
	private static Connection cn;
	public static Connection createConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");//FACTORY METHOD USED TOCREATE THE OBJECT OF DRIVER CLASS
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/complain","root","123456789");//CONNECTION STRING
		}                                
		
		//PROTOCOL    NAME OR IP ADDRESS OF THE MACHINE WHERE DB HAS BEEN INSTALL
		//PORTNO
		catch(SQLException |ClassNotFoundException cse)
		{
			System.out.println(cse);
		}
		return cn;
	}

}
