package P2.Inleveropdracht;

public class OVChipkaart {
	private int kaartNummer;
	private java.sql.Date geldigTot;
	private int klasse;
	private double saldo;
	private int reizigerID;
	
	public OVChipkaart(int kaartNummer, java.sql.Date geldigTot, int klasse, double saldo, int reizigerID) {
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerID = reizigerID;
	}
	
	public int getKaartNummer() {
		return kaartNummer;
	}
	
	public java.sql.Date getGeldigTot() {
		return geldigTot;
	}
	
	public int getKlasse() {
		return klasse;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public int getReizger() {
		return reizigerID;
	}
	
	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}
	
	public void setGelidgTot(java.sql.Date geldigTot) {
		this.geldigTot = geldigTot;
	}
	
	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setReiziger(int reizigerID) {
		this.reizigerID = reizigerID;
	}
	
	public String toString() {
		return "OVChipkaart met nummer " + this.kaartNummer + " is geldig tot " + this.geldigTot + " is geldig voor klasse " + this.klasse + " heeft een saldo van €" + this.saldo + " en staat op naam van de reiziger met id " + this.reizigerID; 
	}
}
