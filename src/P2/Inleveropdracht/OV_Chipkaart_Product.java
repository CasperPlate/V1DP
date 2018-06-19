package P2.Inleveropdracht;

public class OV_Chipkaart_Product {
	private int ovProductID;
	private int kaartNummer;
	private int productNummer;
	private String reisProductStatus;
	private java.sql.Date lastUpdate;
	
	public OV_Chipkaart_Product(int ovProductID, int kaartNummer, int productNummer, String reisProductStatus, java.sql.Date lastUpdate) {
		this.setOvProductID(ovProductID);
		this.setKaartNummer(kaartNummer);
		this.setProductNummer(productNummer);
		this.setReisProductStatus(reisProductStatus);
		this.setLastUpdate(lastUpdate);
	}

	public int getOvProductID() {
		return ovProductID;
	}

	public void setOvProductID(int ovProductID) {
		this.ovProductID = ovProductID;
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public int getProductNummer() {
		return productNummer;
	}

	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}

	public String getReisProductStatus() {
		return reisProductStatus;
	}

	public void setReisProductStatus(String reisProductStatus) {
		this.reisProductStatus = reisProductStatus;
	}

	public java.sql.Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(java.sql.Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
