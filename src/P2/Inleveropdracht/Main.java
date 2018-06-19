package P2.Inleveropdracht;

public class Main {
	public static void main(String[] args) {
		ReizigerOracleDAOImpl reizigerDAO = new ReizigerOracleDAOImpl();
		OVChipkaartOracleDAOImpl ovDAO = new OVChipkaartOracleDAOImpl();
		System.out.println(reizigerDAO.findAll());
		Reiziger nieuw = new Reiziger(1, "C", "Cappie", "Plate", java.sql.Date.valueOf("1997-08-17"));
		OVChipkaart kaart = new OVChipkaart(1, java.sql.Date.valueOf("2020-05-31"), 2, 20.0, 1);
		//ovDAO.save(kaart);
		System.out.println(ovDAO.findAll());
		System.out.println(ovDAO.findReizigerByKaartNummer(kaart));
	}
}
