package hcmute.springbootdemo.Service.impl;

import hcmute.springbootdemo.Entity.Product;
import hcmute.springbootdemo.Repository.ProductRepository;
import hcmute.springbootdemo.Service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    ProductRepository productRepository;
    
	@Override
	public List<Product> findAllById(Iterable<Integer> ids) {
		return productRepository.findAllById(ids);
	}

    @Override
	public <S extends Product> S save(S entity) {
		return productRepository.save(entity);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}


	@Override
	public long count() {
		return productRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	public void delete(Product entity) {
		productRepository.delete(entity);
	}

	@Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findProductById(id);
    }

    @Override
    public int countProduct() {
        return productRepository.countProduct();
    }

	@Override
	public int countProductsByCategoryId(int categoryId) {
		return productRepository.countProductsByCategoryId(categoryId);
	}

	@Override
	public List<Product> findProductByCategory(int categoryId) {
		return productRepository.findProductByCategoryId(categoryId);
	}

	@Override
	public List<Product> findProductByCategoryIdAndBrandId(int categoryId, int brandId) {
		return productRepository.findProductByCategoryIdAndBrandId(categoryId, brandId);
	}



	@Override
	public List<Product> get10Newest() {
		return productRepository.findTop10ByAvailableOrderByCreatedDateDesc(true);
	}

	@Override
	public List<Product> get10Best() {
		return productRepository.findTop10ByAvailableOrderBySoldCountDesc(true);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public List<Product> findProductsByBrandId(int brandId) {
		return productRepository.findProductsByBrandId(brandId);
	}

	@Override
	public List<Product> findProductsByName(String name) {
		return productRepository.findProductsByName(name);
	}


}
