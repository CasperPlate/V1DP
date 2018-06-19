package P2.Inleveropdracht;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductOracleDAOImpl extends OracleBaseDAO implements ProductDAO {

	@Override
	public List<Product> findAll() {
		List<Product> gevondenProducten = new ArrayList<Product>();
		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM product";
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				int productNummer = dbResultSet.getInt("productnummer");
				String productNaam = dbResultSet.getString("productnaam");
				String beschrijving = dbResultSet.getString("beschrijving");
				double prijs = dbResultSet.getDouble("prijs");
				Product newProduct = new Product(productNummer, productNaam, beschrijving, prijs);
				gevondenProducten.add(newProduct);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return gevondenProducten;
	}

	@Override
	public List<Product> findByProductNummer(int productNummer) {
		List<Product> gevondenProducten = new ArrayList<Product>();
		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM product WHERE productnummer = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, productNummer);
			ResultSet dbResultSet = pstmt.executeQuery();
			while (dbResultSet.next()) {
				int pNr = dbResultSet.getInt("productnummer");
				String productNaam = dbResultSet.getString("productnaam");
				String beschrijving = dbResultSet.getString("beschrijving");
				double prijs = dbResultSet.getDouble("prijs");
				Product newProduct = new Product(pNr, productNaam, beschrijving, prijs);
				gevondenProducten.add(newProduct); 
			}
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return gevondenProducten;
	}

	@Override
	public List<Product> findByProductNaam(String productNaam) {
		List<Product> gevondenProducten = new ArrayList<Product>();
		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM product WHERE productnaam = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, productNaam);
			ResultSet dbResultSet = pstmt.executeQuery();
			while (dbResultSet.next()) {
				int pNr = dbResultSet.getInt("productnummer");
				String pNm = dbResultSet.getString("productnaam");
				String beschrijving = dbResultSet.getString("beschrijving");
				double prijs = dbResultSet.getDouble("prijs");
				Product newProduct = new Product(pNr, pNm, beschrijving, prijs);
				gevondenProducten.add(newProduct); 
			}
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return gevondenProducten;
	}

	@Override
	public void save(Product product) {
		try(Connection con = super.getConnection()) {
			String query = "INSERT INTO product VALUES(?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, product.getProductNummer());
			pstmt.setString(2, product.getProductNaam());
			pstmt.setString(3, product.getBeschrijving());
			pstmt.setDouble(4, product.getPrijs());
			pstmt.executeQuery();
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}	
	}

	@Override
	public Product update(Product product) {
		try (Connection con = super.getConnection()) {
			String query = "UPDATE ov_chipkaart SET productnaam = ?, beschrijving = ?, prijs = ? WHERE productnummer = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, product.getProductNaam());
			pstmt.setString(2, product.getBeschrijving());
			pstmt.setDouble(3, product.getPrijs());
			pstmt.setInt(4, product.getProductNummer());
			pstmt.executeQuery();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean delete(Product product) {
		try (Connection con = super.getConnection()) {
			String query = "DELETE FROM product WHERE kaartnummer = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, product.getProductNummer());
			pstmt.executeQuery();
			return true;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
}
