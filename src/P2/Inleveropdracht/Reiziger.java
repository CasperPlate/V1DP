package P2.Inleveropdracht;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Reiziger {
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achterNaam;
	private Date gbdatum;
	private List<OVChipkaart> deKaarten = new ArrayList<OVChipkaart>();
	
	public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achterNaam, Date gbdatum) {
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achterNaam = achterNaam;
		this.gbdatum = gbdatum;
	}
	
	public List<OVChipkaart> getChipkaarten() {
		return this.deKaarten;
	}
	
	public int getReizigerID() {
		return reizigerID;
	}
	
	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}
	
	public String getVoorletters() {
		return voorletters;
	}
	
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	
	public String getAchernaam() {
		return achterNaam;
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
	
	public Date getGBDatum() {
		return gbdatum;
	}
	
	public void setGBDatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}
	
	public String toString() {
		return "Reiziger " + reizigerID + " met naam " + getNaam() + " is geboren op " + gbdatum;
	}
}
