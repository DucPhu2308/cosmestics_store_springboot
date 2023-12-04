package hcmute.springbootdemo.Service.impl;

import hcmute.springbootdemo.Entity.Cart_Product;
import hcmute.springbootdemo.Repository.Cart_ProductRepository;
import hcmute.springbootdemo.Service.ICart_Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Cart_ProductServiceImpl implements ICart_Product {

    @Autowired
    Cart_ProductRepository cart_ProductRepository;

	@Override
	public <S extends Cart_Product> S save(S entity) {
		return cart_ProductRepository.save(entity);
	}

	@Override
	public int countCart_ProductsByCartId(int cart_id) {
		return cart_ProductRepository.countCart_ProductsByCartId(cart_id);
	}

	@Override
	public int sumTotalProductByCartID(int cart_id) {

		if(cart_ProductRepository.findCart_ProductsByCartId(cart_id).isEmpty())
			return 0;
		else{
			return cart_ProductRepository.sumTotal(cart_id);
		}
	}

	@Override
	public List<Cart_Product> findCart_ProductsByCartId(int cart_id) {
		return cart_ProductRepository.findCart_ProductsByCartId(cart_id);
	}


	@Override
	public List<Cart_Product> findAll() {
		return cart_ProductRepository.findAll();
	}

	@Override
	public Optional<Cart_Product> findById(Integer id) {
		return cart_ProductRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cart_ProductRepository.existsById(id);
	}

	@Override
	public long count() {
		return cart_ProductRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		cart_ProductRepository.deleteById(id);
	}

	@Override
	public void delete(Cart_Product entity) {
		cart_ProductRepository.delete(entity);
	}
    
    
	@Override
	public int getMaximumId(){
		return cart_ProductRepository.getMaximumId();
	}
    
}
