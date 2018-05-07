package P1.Inleveropdracht;

public class Main {
	public static void main(String[] args) {
		ReizigerOracleDAOImpl DAO = new ReizigerOracleDAOImpl();
		Reiziger R1 = new Reiziger(0, "c", null, "plate", "17-08-1997");
		DAO.save(R1);
		System.out.println(DAO.findAll());
		R1.setGBDatum("10-10-1997");
		DAO.update(R1);
		System.out.println(DAO.findAll());
	}
}
