package P2.Lesopdracht;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDAOImpl extends OracleBaseDAO implements ReizigerDAO{
	private ArrayList<Reiziger> alleReizigers = new ArrayList<Reiziger>();
	public List<Reiziger> findAll() {
		return alleReizigers;
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
		int index = 0;
		for (Reiziger r : alleReizigers) {
			if (r.getReizigerID() == reiziger.getReizigerID()) {
				alleReizigers.set(index, reiziger);
				break;
			} else {
				index++;
			}
		}
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) {
		int index = 0;
		for (Reiziger r : alleReizigers) {
			if (r.getReizigerID() == reiziger.getReizigerID()) {
				alleReizigers.remove(index);
				return true;
			} else {
				index++;
			}
		}
		return false;

	}
}
