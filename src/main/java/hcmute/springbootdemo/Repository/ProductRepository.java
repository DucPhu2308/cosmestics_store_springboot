package hcmute.springbootdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.springbootdemo.Entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    Product findProductById(int productId);

    List<Product> findProductByCategoryId(int categoryId);

    List<Product> findProductByCategoryIdAndBrandId(int categoryId, int brandId);

    @Query("select count(*) from Product ")
    int countProduct();

    // top 10 new product by created date desc, available = true
    List<Product> findTop10ByAvailableOrderByCreatedDateDesc(boolean available);

    // top 10 product by sold quantity
    List<Product> findTop10ByAvailableOrderBySoldCountDesc(boolean available);
}
