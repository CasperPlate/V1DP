package P5.H2;

import java.util.List;

public interface ProductDAO {
	public List<Product> findAll();
	
	public List<Product> findByProductNummer(int productNummer);
	
	public List<Product> findByProductNaam(String productNaam);
	
	public void save(Product product);

	public Product update(Product product);

	public boolean delete(Product product);
}
