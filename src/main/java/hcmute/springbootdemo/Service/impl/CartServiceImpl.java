package hcmute.springbootdemo.Service.impl;

import hcmute.springbootdemo.Entity.Cart;
import hcmute.springbootdemo.Repository.CartRepository;
import hcmute.springbootdemo.Service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    CartRepository cartRepository;

	@Override
	public <S extends Cart> S save(S entity) {
		return cartRepository.save(entity);
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public Optional<Cart> findById(Integer id) {
		return cartRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cartRepository.existsById(id);
	}

	@Override
	public long count() {
		return cartRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		cartRepository.deleteById(id);
	}

	@Override
	public void delete(Cart entity) {
		cartRepository.delete(entity);
	}

    
}
