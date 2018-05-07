package P1.Inleveropdracht;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDAOImpl implements ReizigerDAO{
	private ArrayList<Reiziger> alleReizigers = new ArrayList<Reiziger>();
	public List<Reiziger> findAll() {
		return alleReizigers;
	}
	
	public List<Reiziger> findByGBdatum(String GBdatum) throws ParseException{		
        List<Reiziger> gevondenReizigers = new ArrayList<Reiziger>();
        for (Reiziger r : alleReizigers) {
        	if (r.getGBDatum().equals(GBdatum)) {
        		gevondenReizigers.add(r);
        	}
        }
        return gevondenReizigers;
	}
	
	public Reiziger save(Reiziger reiziger) {
		alleReizigers.add(reiziger);
		return reiziger;
	}
	
	public Reiziger update(Reiziger reiziger) {
		int index = 0;
		for (Reiziger r : alleReizigers) {
			if (r.getReizigerID() == reiziger.getReizigerID()) {
				alleReizigers.set(index, reiziger);
				break;
			} else {
				index++;
			}
		}
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) {
		int index = 0;
		for (Reiziger r : alleReizigers) {
			if (r.getReizigerID() == reiziger.getReizigerID()) {
				alleReizigers.remove(index);
				return true;
			} else {
				index++;
			}
		}
		return false;

	}
}
