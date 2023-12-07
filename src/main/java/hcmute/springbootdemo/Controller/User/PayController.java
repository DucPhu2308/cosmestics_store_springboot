package hcmute.springbootdemo.Controller.User;


import hcmute.springbootdemo.Entity.Cart;
import hcmute.springbootdemo.Entity.Cart_Product;
import hcmute.springbootdemo.Entity.Order;
import hcmute.springbootdemo.Entity.Product;
import hcmute.springbootdemo.Service.impl.CartServiceImpl;
import hcmute.springbootdemo.Service.impl.Cart_ProductServiceImpl;
import hcmute.springbootdemo.Service.impl.OrderServiceImpl;
import hcmute.springbootdemo.Service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path="/pay_success")
public class PayController {

    @Autowired
    Cart_ProductServiceImpl cart_productService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CartServiceImpl cartService;

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping(value = " ")
    public String paySuccess(HttpSession session){
        int id= (int) session.getAttribute("cartID");

        Order order = (Order) session.getAttribute("order_pay");

        order.setCart(cartService.findCartById(id));
        order.setArriveDate(null);
        order.setOrderDate(new Date());
        order.setShippingFee(0);


        float total = 0;
        float totalDiscount = 0;
        List<Cart_Product> cart_products = cart_productService.findCart_ProductsByCartId(id);
        for(Cart_Product cart_product : cart_products){
            total += cart_product.getProduct().getPrice() * cart_product.getQuantity();
            totalDiscount += cart_product.getQuantity() * (cart_product.getProduct().getPrice() - (cart_product.getProduct().getPrice()-(cart_product.getProduct().getPrice()*cart_product.getProduct().getDiscountPercent())));

            //Cập nhật lai số lượng sản phẩm và số lượng đã bán
            Product product = productService.findById(cart_product.getProduct().getId()).get();
            product.setStock(product.getStock() - cart_product.getQuantity());
            if(product.getStock() - cart_product.getQuantity() == 0){
                product.setAvailable(false);
            }
            product.setSoldCount(product.getSoldCount() + cart_product.getQuantity());
            productService.save(product);

        }
        order.setSubTotal(total);

        order.setTotalDiscount(totalDiscount);
        order.setTotal(total-totalDiscount);

        Cart cart = cartService.findCartById(id);

        order.setOrderDate(new Date());

        cart.setActive(false);
        order.setPaid(true);
        order.setId(orderService.getMaxOrderID());
        cartService.save(cart);
        orderService.save(order);

        int countCart= session.getAttribute("CountCart") == null ? 0 : (int) session.getAttribute("CountCart");
        session.setAttribute("CountCart", countCart - 1);

        order.setPaid(true);


        return "user/pay";
    }
}
