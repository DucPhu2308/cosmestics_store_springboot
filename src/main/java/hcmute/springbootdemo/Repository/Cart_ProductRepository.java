package hcmute.springbootdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.springbootdemo.Entity.Cart_Product;

@Repository
public interface Cart_ProductRepository extends JpaRepository<Cart_Product, Integer>{

    //tính tổng tiền tất cả các sản phẩm trong giỏ hàng
    @Query("select sum(cp.totalPrice) from Cart_Product cp")
    int sumTotal();
}
