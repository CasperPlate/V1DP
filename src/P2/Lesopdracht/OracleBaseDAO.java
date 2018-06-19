package P2.Lesopdracht;

import java.sql.*;

public class OracleBaseDAO {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:49161/xe";
	private static final String DB_USER = "ov";
	private static final String DB_PASS = "topsecret";
	private static Connection conn;
	
	protected final Connection getConnection() {
		try {
			Class.forName(DB_DRIV);
		}
		catch (ClassNotFoundException e1){
			e1.printStackTrace();
		}

		try {

			conn = DriverManager.getConnection(
					DB_URL, DB_USER, DB_PASS);

		} catch (SQLException e) {

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
