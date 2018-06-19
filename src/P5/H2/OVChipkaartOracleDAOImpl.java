package P5.H2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartOracleDAOImpl extends H2BaseDAO implements OVChipkaartDAO{

	@Override
	public Reiziger findReizigerByKaartNummer(OVChipkaart kaart) {
		ReizigerOracleDAOImpl reizigerDAO = new ReizigerOracleDAOImpl();
		Reiziger reiziger = reizigerDAO.findByID(kaart.getReizger());
		return reiziger;
	}
	
	@Override
	public List<OVChipkaart> findAll() {
		List<OVChipkaart> gevondenKaarten = new ArrayList<OVChipkaart>();
		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM ov_chipkaart";
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				int kaartNummer = dbResultSet.getInt("kaartnummer");
				java.sql.Date geldigTot = dbResultSet.getDate("geldigtot");
				int klasse = dbResultSet.getInt("klasse");
				double saldo = dbResultSet.getDouble("saldo");
				int reizigerID = dbResultSet.getInt("reizigerid");
				OVChipkaart newOVChipkaart = new OVChipkaart(kaartNummer, geldigTot, klasse, saldo, reizigerID);
				gevondenKaarten.add(newOVChipkaart);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return gevondenKaarten;
	}

	@Override
	public List<OVChipkaart> findByKaartNummer(int kaartNummer) {
		List<OVChipkaart> gevondenKaarten = new ArrayList<OVChipkaart>();
		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM ov_chipkaart WHERE kaartnummer = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, kaartNummer);
			ResultSet dbResultSet = pstmt.executeQuery(query);
			while (dbResultSet.next()) {
				int kaartNr = dbResultSet.getInt("kaartnummer");
				java.sql.Date geldigTot = dbResultSet.getDate("geldigtot");
				int klasse = dbResultSet.getInt("klasse");
				double saldo = dbResultSet.getDouble("saldo");
				int reizigerID = dbResultSet.getInt("reizigerid");
				OVChipkaart newOVChipkaart = new OVChipkaart(kaartNr, geldigTot, klasse, saldo, reizigerID);
				gevondenKaarten.add(newOVChipkaart);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return gevondenKaarten;
	}

	@Override
	public List<OVChipkaart> findByReiziger(int reizigerID) {
		List<OVChipkaart> gevondenKaarten = new ArrayList<OVChipkaart>();
		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM ov_chipkaart WHERE reizigerid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reizigerID);
			ResultSet dbResultSet = pstmt.executeQuery(query);
			while (dbResultSet.next()) {
				int kaartNummer = dbResultSet.getInt("kaartnummer");
				java.sql.Date geldigTot = dbResultSet.getDate("geldigtot");
				int klasse = dbResultSet.getInt("klasse");
				double saldo = dbResultSet.getDouble("saldo");
				int reiziger = dbResultSet.getInt("reizigerid");
				OVChipkaart newOVChipkaart = new OVChipkaart(kaartNummer, geldigTot, klasse, saldo, reiziger);
				gevondenKaarten.add(newOVChipkaart);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return gevondenKaarten;
	}

	@Override
	public void save(OVChipkaart kaart) {
		try (Connection con = super.getConnection()) {
			String query = "INSERT INTO ov_chipkaart VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, kaart.getKaartNummer());
			pstmt.setDate(2, kaart.getGeldigTot());
			pstmt.setInt(3, kaart.getKlasse());
			pstmt.setDouble(4, kaart.getSaldo());
			pstmt.setInt(5, kaart.getReizger());
			pstmt.executeUpdate();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	@Override
	public OVChipkaart update(OVChipkaart kaart) {
		try (Connection con = super.getConnection()) {
			String query = "UPDATE ov_chipkaart SET geldigtot = ?, klasse = ?, saldo = ?, reizigerid = ? WHERE kaartnummer = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDate(1, kaart.getGeldigTot());
			pstmt.setInt(2, kaart.getKlasse());
			pstmt.setDouble(3, kaart.getKlasse());
			pstmt.setInt(4, kaart.getReizger());
			pstmt.setInt(5, kaart.getKaartNummer());
			pstmt.executeQuery();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return kaart;
	}

	@Override
	public boolean delete(OVChipkaart kaart) {
		try (Connection con = super.getConnection()) {
			String query = "DELETE FROM ov_chipkaart WHERE kaartnummer = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, kaart.getKaartNummer());
			pstmt.executeQuery();
			return true;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

}
