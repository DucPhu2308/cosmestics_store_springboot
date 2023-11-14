package hcmute.springbootdemo.Services;

import hcmute.springbootdemo.Entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findProductById(int id);


    int countProduct();
}
