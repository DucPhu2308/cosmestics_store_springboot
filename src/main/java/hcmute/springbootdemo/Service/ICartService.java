package hcmute.springbootdemo.Service;

import hcmute.springbootdemo.Entity.Cart;
import hcmute.springbootdemo.Entity.User;

import java.util.List;
import java.util.Optional;

public interface ICartService {

	void delete(Cart entity);

	void deleteById(Integer id);

	long count();

	boolean existsById(Integer id);

	Optional<Cart> findById(Integer id);

	List<Cart> findAll();

	<S extends Cart> S save(S entity);

	List<Cart> findCartByUserId(int userId);

	void updateCart(Cart cart);
}
