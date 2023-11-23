package hcmute.springbootdemo.Service;

import hcmute.springbootdemo.Entity.Cart_Product;
import java.util.List;
import java.util.Optional;

public interface ICart_Product {

	void delete(Cart_Product entity);

	void deleteById(Integer id);

	long count();

	boolean existsById(Integer id);

	Optional<Cart_Product> findById(Integer id);

	List<Cart_Product> findAll();

	<S extends Cart_Product> S save(S entity);

}
