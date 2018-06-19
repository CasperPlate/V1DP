package P5.H2;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	
	Product(int pNr, String pNm, String besch, double prijs) {
		this.productNummer = pNr;
		this.productNaam = pNm;
		this.beschrijving = besch;
		this.prijs = prijs;
	}
	
	public int getProductNummer() {
		return productNummer;
	}
	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}
	public String getProductNaam() {
		return productNaam;
	}
	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	
}
