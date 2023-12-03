package hcmute.springbootdemo.Controller.User;


import hcmute.springbootdemo.Entity.Cart;
import hcmute.springbootdemo.Entity.Cart_Product;
import hcmute.springbootdemo.Entity.Order;
import hcmute.springbootdemo.Entity.Product;
import hcmute.springbootdemo.Repository.CartRepository;
import hcmute.springbootdemo.Repository.Cart_ProductRepository;
import hcmute.springbootdemo.Service.impl.CartServiceImpl;
import hcmute.springbootdemo.Service.impl.Cart_ProductServiceImpl;
import hcmute.springbootdemo.Service.impl.OrderServiceImpl;
import hcmute.springbootdemo.Service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/order_cart")
public class OrderController {

    @Autowired
    Cart_ProductServiceImpl cart_productService;

    @Autowired
    CartServiceImpl cartService;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    ProductServiceImpl productService;

    @GetMapping(value="{id}")
    public String order(ModelMap modelMap, @PathVariable("id") int id){
        Order order = new Order();
        order.setCart(cartService.findCartById(id));
        modelMap.addAttribute("order", order);
        return "user/order";
    }

    @PostMapping(value="/add_orderCart/{id}")
    public String addOrder(@PathVariable("id") int id, @ModelAttribute("order") Order order){
        order.setCart(cartService.findCartById(id));
        order.setPaid(false);
        order.setArriveDate(null);
        order.setOrderDate(null);
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
        cart.setActive(false);


        cartService.save(cart);
        orderService.save(order);


        return "redirect:/cart";
    }

}
