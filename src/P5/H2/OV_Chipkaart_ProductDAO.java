package P5.H2;

import java.util.List;

public interface OV_Chipkaart_ProductDAO {
	public OV_Chipkaart_Product findByOVProductID(int ovProductID);
	public List<OV_Chipkaart_Product> findBykaartNummer(OVChipkaart kaart);
	public List<OV_Chipkaart_Product> findByProductNummer(Product product);
	public void save(OV_Chipkaart_Product ovProduct);
	public OV_Chipkaart_Product update(OV_Chipkaart_Product ovProduct);
	public boolean delete(OV_Chipkaart_Product ovProduct);
}
