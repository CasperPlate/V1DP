package P1;

import java.sql.*;

public class Main {

	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:49161/xe";
	private static final String DB_USER = "casper";
	private static final String DB_PASS = "topsecret";
	private static Connection conn;
	
	public static void main(String[] args) throws SQLException{
		try {
			Class.forName(DB_DRIV).newInstance();
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		System.out.println("Connection made");
		
		Statement stmt = conn.createStatement();
		String strQuery = "DELETE FROM cursussen WHERE CODE = 'GEN'  ";
		
		stmt.executeUpdate(strQuery);
		System.out.println("Cursus GEN verwijderd.\n");
		
		
		String queryText = "Select * FROM cursussen";
		
		ResultSet rs = stmt.executeQuery(queryText);
		
		System.out.println("Eerste ResultSet: " + rs + "\n");
		
		String code;
		String omschrijving;
		String type;
		int lengte;
		while (rs.next()) {   
			code = rs.getString("CODE");	
			omschrijving = rs.getString("OMSCHRIJVING");
			type = rs.getString("TYPE"); 
			lengte = rs.getInt("LENGTE");
			System.out.println("Cursus: " + code + ", " + omschrijving + ", type " + type + ", lengte " + lengte);
		}	
		rs.close();
		System.out.println("");

		strQuery = "INSERT INTO cursussen values('S05','Introductiecursus SQL vervolg','ALG','10')";
		stmt.executeUpdate(strQuery);
		System.out.println("S05 toegevoegd aan cursussen");
		stmt.close();	

	
		strQuery = "UPDATE cursussen SET code = '?' WHERE code = '?'";
		PreparedStatement pstmt = conn.prepareStatement(strQuery);
		pstmt.setString(1, "S01");
		pstmt.setString(2, "S02");
		
		pstmt.executeUpdate();
		System.out.println("Cursus S02 aangepast\n");
		
		pstmt.close();
		
		strQuery = "SELECT ? FROM ?";
		PreparedStatement pstmt2 = conn.prepareStatement(strQuery);
		pstmt2.setString(1, "*");
		pstmt2.setString(2, "cursussen");
		
		ResultSet rs2 = pstmt2.executeQuery();
		System.out.println("Tweede ResultSet: " + rs + "\n");
		while (rs2.next()) {   
			code = rs2.getString("CODE");	
			omschrijving = rs2.getString("OMSCHRIJVING");
			type = rs2.getString("TYPE"); 
			lengte = rs2.getInt("LENGTE");
			System.out.println("Cursus: " + code + ", " + omschrijving + ", type " + type + ", lengte " + lengte);
		}	
		
		pstmt2.close();
		
		strQuery = "DELETE FROM cursussen WHERE code = '?'";
		PreparedStatement pstmt3 = conn.prepareStatement(strQuery);
		pstmt3.setString(1, "S03");
		
		pstmt3.executeUpdate();
		System.out.println("Cursus S03 verwijderd.\n");
		
		pstmt3.close();

		
		conn.close();

	}
}