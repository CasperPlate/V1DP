package P2.Lesopdracht;

import java.text.ParseException;
import java.util.List;

public interface ReizigerDAO {
	public List<Reiziger> findAll();

	public List<Reiziger> findByGBdatum(java.sql.Date GBdatum) throws ParseException;
	
	public void save(Reiziger reiziger);

	public Reiziger update(Reiziger reiziger);

	public boolean delete(Reiziger reiziger);
}
