package P5.H2;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDAOImpl extends H2BaseDAO implements ReizigerDAO{
	public List<Reiziger> findAll() {
		List<Reiziger> gevondenReizigers = new ArrayList<Reiziger>();
        try (Connection con = super.getConnection()) {
        	String query = "SELECT * FROM reiziger";
        	Statement stmt = con.createStatement();
        	ResultSet dbResultSet = stmt.executeQuery(query);
        	while (dbResultSet.next()) {
        		int reizigerID = dbResultSet.getInt("reizigerid");
        		String voorl = dbResultSet.getString("voorletters");
        		String tussen = dbResultSet.getString("tussenvoegsel");
        		String achtern = dbResultSet.getString("achternaam");
        		Date geboorteDatum = dbResultSet.getDate("gebortedatum");
        		Reiziger newReiziger = new Reiziger(reizigerID, voorl, tussen, achtern, geboorteDatum);
        		gevondenReizigers.add(newReiziger);
        	}
        }
        catch (SQLException sqle) {
        	sqle.printStackTrace();
        }
        return gevondenReizigers;
	}
	
	public Reiziger findByID(int id) {
		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM reiziger WHERE reizigerid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
			ResultSet dbResultSet = pstmt.executeQuery();
				while (dbResultSet.next()) {
				int reizigerID = dbResultSet.getInt("reizigerid");
	    		String voorl = dbResultSet.getString("voorletters");
	    		String tussen = dbResultSet.getString("tussenvoegsel");
	    		String achtern = dbResultSet.getString("achternaam");
	    		Date geboorteDatum = dbResultSet.getDate("gebortedatum");
	    		Reiziger newReiziger = new Reiziger(reizigerID, voorl, tussen, achtern, geboorteDatum);
	    		return newReiziger;
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}
	
	public List<Reiziger> findByGBdatum(java.sql.Date GBdatum) throws ParseException{		
        List<Reiziger> gevondenReizigers = new ArrayList<Reiziger>();
        try (Connection con = super.getConnection()) {
        	String query = "SELECT * FROM reiziger WHERE gebortedatum = ?";
        	PreparedStatement pstmt = con.prepareStatement(query);
        	pstmt.setDate(1, GBdatum);
        	ResultSet dbResultSet = pstmt.executeQuery();
        	while (dbResultSet.next()) {
        		int reizigerID = dbResultSet.getInt("reizigerid");
        		String voorl = dbResultSet.getString("voorletters");
        		String tussen = dbResultSet.getString("tussenvoegsel");
        		String achtern = dbResultSet.getString("achternaam");
        		Date geboorteDatum = dbResultSet.getDate("gebortedatum");
        		Reiziger newReiziger = new Reiziger(reizigerID, voorl, tussen, achtern, geboorteDatum);
        		gevondenReizigers.add(newReiziger);
        	}
        }
        catch (SQLException sqle) {
        	sqle.printStackTrace();
        }
        return gevondenReizigers;
	}
	
	public void save(Reiziger reiziger) {
		try (Connection con = super.getConnection()) {
			String query = "INSERT INTO reiziger VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reiziger.getReizigerID());
			pstmt.setString(2, reiziger.getVoorletters());
			pstmt.setString(3, reiziger.getTussenvoegsel());
			pstmt.setString(4, reiziger.getAchernaam());
			pstmt.setDate(5, reiziger.getGBDatum());
			pstmt.executeQuery();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public Reiziger update(Reiziger reiziger) {
		try (Connection con = super.getConnection()) {
			String query = "UPDATE reiziger SET voorletters = ?, tussenvoegsel = ?, achternaam = ?, gebortedatum = ? WHERE reizigerid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, reiziger.getVoorletters());
			pstmt.setString(2, reiziger.getTussenvoegsel());
			pstmt.setString(3, reiziger.getAchernaam());
			pstmt.setDate(4, reiziger.getGBDatum());
			pstmt.setInt(5,  reiziger.getReizigerID());
			pstmt.executeQuery();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) {
		try (Connection con = super.getConnection()) {
			String query = "DELETE FROM reiziger WHERE reizigerid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reiziger.getReizigerID());
			pstmt.executeQuery();
			return true;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
}
