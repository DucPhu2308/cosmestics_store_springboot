package hcmute.springbootdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.springbootdemo.Entity.Cart_Product;

@Repository
public interface Cart_ProductRepository extends JpaRepository<Cart_Product, Integer>{

}
