package hcmute.springbootdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.springbootdemo.Entity.Cart;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

    List<Cart> findCartsByUserId(int userId);

}
