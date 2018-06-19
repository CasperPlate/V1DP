package P2.Inleveropdracht;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OV_Chipkaart_ProductOracleDAOImpl extends OracleBaseDAO implements OV_Chipkaart_ProductDAO {

	@Override
	public OV_Chipkaart_Product findByOVProductID(int ovProductID) {
		try (Connection con = super.getConnection()) {
			OV_Chipkaart_Product newOVProduct;
			String query = "SELECT * FROM ov-chipkaart_product WHERE ovproductid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ovProductID);
			ResultSet dbResultSet = pstmt.executeQuery();
			while (dbResultSet.next()) {
				int productID = dbResultSet.getInt("ovproductid");
				int kaartNummer = dbResultSet.getInt("kaartnummer");
				int productNummer = dbResultSet.getInt("productnummer");
				String reisProductStatus = dbResultSet.getString("reisproductstatus");
				java.sql.Date lastUpdate = dbResultSet.getDate("lastupdate");
				newOVProduct = new OV_Chipkaart_Product(productID, kaartNummer, productNummer, reisProductStatus, lastUpdate);
				return newOVProduct;
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public List<OV_Chipkaart_Product> findBykaartNummer(OVChipkaart kaart) {
		List<OV_Chipkaart_Product> gevondenOVProducten = new ArrayList<OV_Chipkaart_Product>();
		try (Connection con = super.getConnection()) {
			OV_Chipkaart_Product newOVProduct;
			String query = "SELECT * FROM ov-chipkaart_product WHERE kaartnummer = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, kaart.getKaartNummer());
			ResultSet dbResultSet = pstmt.executeQuery();
			while (dbResultSet.next()) {
				int productID = dbResultSet.getInt("ovproductid");
				int kaartNummer = dbResultSet.getInt("kaartnummer");
				int productNummer = dbResultSet.getInt("productnummer");
				String reisProductStatus = dbResultSet.getString("reisproductstatus");
				java.sql.Date lastUpdate = dbResultSet.getDate("lastupdate");
				newOVProduct = new OV_Chipkaart_Product(productID, kaartNummer, productNummer, reisProductStatus, lastUpdate);
				gevondenOVProducten.add(newOVProduct);
			}
			return gevondenOVProducten;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	@Override
	public List<OV_Chipkaart_Product> findByProductNummer(Product product) {
		List<OV_Chipkaart_Product> gevondenOVProducten = new ArrayList<OV_Chipkaart_Product>();
		try (Connection con = super.getConnection()) {
			OV_Chipkaart_Product newOVProduct;
			String query = "SELECT * FROM ov-chipkaart_product WHERE productnummer = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, product.getProductNummer());
			ResultSet dbResultSet = pstmt.executeQuery();
			while (dbResultSet.next()) {
				int productID = dbResultSet.getInt("ovproductid");
				int kaartNummer = dbResultSet.getInt("kaartnummer");
				int productNummer = dbResultSet.getInt("productnummer");
				String reisProductStatus = dbResultSet.getString("reisproductstatus");
				java.sql.Date lastUpdate = dbResultSet.getDate("lastupdate");
				newOVProduct = new OV_Chipkaart_Product(productID, kaartNummer, productNummer, reisProductStatus, lastUpdate);
				gevondenOVProducten.add(newOVProduct);
			}
			return gevondenOVProducten;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	@Override
	public void save(OV_Chipkaart_Product ovProduct) {
		try(Connection con = super.getConnection()) {
			String query = "INSERT INTO ov-chipkaart_product VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ovProduct.getOvProductID());
			pstmt.setInt(2, ovProduct.getKaartNummer());
			pstmt.setInt(3, ovProduct.getProductNummer());
			pstmt.setString(4, ovProduct.getReisProductStatus());
			pstmt.setDate(5, ovProduct.getLastUpdate());
			pstmt.executeQuery();
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}	
	}

	@Override
	public OV_Chipkaart_Product update(OV_Chipkaart_Product ovProduct) {
		try(Connection con = super.getConnection()) {
			String query = "UPDATE ov-chipkaart_product SET kaartnummer = ?, productnummer = ?, reisproductstatus = ?, lastupdate = ? WHERE ovproductid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ovProduct.getKaartNummer());
			pstmt.setInt(2, ovProduct.getProductNummer());
			pstmt.setString(3, ovProduct.getReisProductStatus());
			pstmt.setDate(4, ovProduct.getLastUpdate());
			pstmt.setInt(5, ovProduct.getOvProductID());
			pstmt.executeQuery();
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return ovProduct;
	}

	@Override
	public boolean delete(OV_Chipkaart_Product ovProduct) {
		try(Connection con = super.getConnection()) {
			String query = "DELETE FROM ov-chipkaart_product WHERE ovproductid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ovProduct.getOvProductID());
			pstmt.executeQuery();
			return true;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}	
	}
}
