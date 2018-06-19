package P5.H2;

import java.text.ParseException;
import java.util.List;

public interface ReizigerDAO {
	public List<Reiziger> findAll();

	public Reiziger findByID(int id);
	
	public List<Reiziger> findByGBdatum(java.sql.Date GBdatum) throws ParseException;

	public void save(Reiziger reiziger);

	public Reiziger update(Reiziger reiziger);

	public boolean delete(Reiziger reiziger);
}
