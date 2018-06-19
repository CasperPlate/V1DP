package P5.H2;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;  

public class H2BaseDAO {
	private static final String JDBC_DRIVER = "org.h2.Driver";   
	private static final String DB_URL = "jdbc:h2:~/test";  
	private static final String USER = "sa"; 
	private static final String PASS = ""; 
	private static Connection conn;

	protected final Connection getConnection() {
		try { 
			// STEP 1: Register JDBC driver 
			Class.forName(JDBC_DRIVER); 
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			//STEP 2: Open a connection 
			System.out.println("Connecting to database..."); 
			conn = DriverManager.getConnection(DB_URL,USER,PASS);  
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		if (conn != null) {
			return conn;
		} else {
			return null;
		}
	}

	protected final void closeConnection() {
		try {
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

