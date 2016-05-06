package Klient;

import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	
	Connection conn = null;
	
	public static Connection dbConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\apsik\\Dropbox\\Pomysly\\Lotto\\src\\EmployeeData.sqlite");
			JOptionPane.showMessageDialog(null, "Udalo sie zalogowac");
			return conn;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		return null;
		
	}

}
