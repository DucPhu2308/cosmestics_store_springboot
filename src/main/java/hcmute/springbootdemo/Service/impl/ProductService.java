package hcmute.springbootdemo.Service.impl;

import hcmute.springbootdemo.Entity.Product;
import hcmute.springbootdemo.Repository.ProductRepository;
import hcmute.springbootdemo.Service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    ProductRepository productRepository;


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
}