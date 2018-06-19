package P5.H2;

public class Main {
	public static void main(String[] args) {
		ReizigerOracleDAOImpl reizigerDAO = new ReizigerOracleDAOImpl();
		OVChipkaartOracleDAOImpl ovDAO = new OVChipkaartOracleDAOImpl();
		System.out.println(reizigerDAO.findAll());
		OVChipkaart kaart = new OVChipkaart(1, java.sql.Date.valueOf("2020-05-31"), 2, 20.0, 1);
		ovDAO.save(kaart);
		System.out.println(ovDAO.findAll());
	}
}
