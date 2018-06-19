package P2.Lesopdracht;

public class Main {
	public static void main(String[] args) {
		ReizigerOracleDAOImpl DAO = new ReizigerOracleDAOImpl();
		Reiziger R1 = new Reiziger(0, "c", null, "plate", java.sql.Date.valueOf("1997-08-17"));
		DAO.save(R1);
		System.out.println(DAO.findAll());
		R1.setGBDatum(java.sql.Date.valueOf("1997-10-10"));
		DAO.update(R1);
		System.out.println(DAO.findAll());
	}
}
