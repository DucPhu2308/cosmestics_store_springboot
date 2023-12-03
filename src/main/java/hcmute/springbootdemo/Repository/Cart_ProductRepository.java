package hcmute.springbootdemo.Repository;

import hcmute.springbootdemo.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.springbootdemo.Entity.Cart_Product;

import java.util.List;

@Repository
public interface Cart_ProductRepository extends JpaRepository<Cart_Product, Integer>{

    //tính tổng tiền tất cả các sản phẩm trong giỏ hàng
    @Query("select sum(cp.totalPrice) from Cart_Product cp where cp.cart.id = ?1")
    int sumTotal(int cart_id);

    @Query("select count(*) from Cart_Product cp where cp.cart.id = ?1")
    int countCart_ProductsByCartId(int cart_id);

    List<Cart_Product> findCart_ProductsByCartId(int cart_id);

}
