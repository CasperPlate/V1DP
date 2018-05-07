package P1.Inleveropdracht;

public class Reiziger {
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achterNaam;
	private String gbdatum;
	
	public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achterNaam, String gbdatum) {
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achterNaam = achterNaam;
		this.gbdatum = gbdatum;
	}
	
	public int getReizigerID() {
		return reizigerID;
	}
	
	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}
	
	public String getNaam() {
		String s = voorletters;
		if (tussenvoegsel != null) {
			s += " " + tussenvoegsel;
		}
		s += " " + achterNaam;
		return s;
	}
	
	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}
	
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	
	public void setAchterNaam(String achterNaam) {
		this.achterNaam = achterNaam;
	}
	
	public String getGBDatum() {
		return gbdatum;
	}
	
	public void setGBDatum(String gbdatum) {
		this.gbdatum = gbdatum;
	}
	
	public String toString() {
		return "Reiziger " + reizigerID + " met naam " + getNaam() + " is geboren op " + gbdatum;
	}
}
