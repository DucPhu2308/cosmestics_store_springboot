package hcmute.springbootdemo.Service;

import hcmute.springbootdemo.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Product findProductById(int id);

    int countProduct();

	int countProductsByCategoryId(int categoryId);

	List<Product> findProductByCategory(int categoryId);

	List<Product> findProductByCategoryAndBrand(int categoryId, int brandId);

	void delete(Product entity);

	void deleteById(Integer id);

	long count();

	Optional<Product> findById(Integer id);

	<S extends Product> S save(S entity);

	public List<Product> get10Newest();

	public List<Product> get10Best();


	Page<Product> findAll(Pageable pageable);

	List<Product> findProductsByBrandId(int brandId);

}
