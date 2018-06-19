package P5.H2;

import java.util.List;

public interface OVChipkaartDAO {
	public Reiziger findReizigerByKaartNummer(OVChipkaart kaart);
	
	public List<OVChipkaart> findAll();

	public List<OVChipkaart> findByKaartNummer(int kaartNummer);
	
	public List<OVChipkaart> findByReiziger(int reizigerID);

	public void save(OVChipkaart kaart);

	public OVChipkaart update(OVChipkaart kaart);

	public boolean delete(OVChipkaart kaart);
}
