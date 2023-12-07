package hcmute.springbootdemo.Controller.User;


import hcmute.springbootdemo.Entity.Cart;
import hcmute.springbootdemo.Entity.Cart_Product;
import hcmute.springbootdemo.Entity.Order;
import hcmute.springbootdemo.Entity.Product;
import hcmute.springbootdemo.Service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
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

    @Autowired
    PaymentServiceImpl paymentService;

    @GetMapping(value = " ")
    public String listOrder(ModelMap modelMap, HttpSession session){
        String userId=  session.getAttribute("user_id").toString();
        if(userId == null){
            return "redirect:/login";
        }
        else{
            int user_id =(int) session.getAttribute("user_id");
            System.out.println(user_id);
            List<Cart> carts =cartService.findCartByUserId(user_id);

            for (Cart cart: carts) {
                System.out.println("Tên giỏ hàng của user 20: " + cart.getName()+ "Mã giỏ hàng: " + cart.getId());

            }
            modelMap.addAttribute("carts", carts );
            return "user/order/list_order_payment";
        }
    }
    @GetMapping(value="{id}")
    public String order(ModelMap modelMap, @PathVariable("id") int id) {
        Order order = new Order();
        order.setCart(cartService.findCartById(id));
        modelMap.addAttribute("order", order);
        return "user/order/order";
    }
    @GetMapping(value= "/add_orderCart/{id}")
    public String addOrderCart(ModelMap modelMap, @PathVariable("id") int id, HttpSession session) throws UnsupportedEncodingException {
        Order order = orderService.findOrderByCartId(id);
        int amount= (int)order.getTotal();
        String payMent = paymentService.createPayment(amount*100000);

        return "redirect:"+payMent;
    }
    @PostMapping(value="/add_orderCart/{id}")
    public String addOrder(@PathVariable("id") int id, @ModelAttribute("order") Order order, HttpSession session) throws UnsupportedEncodingException {
        session.setAttribute("cartID",id);
        session.setAttribute("order_pay",order);



        float total = 0;
        float totalDiscount = 0;
        List<Cart_Product> cart_products = cart_productService.findCart_ProductsByCartId(id);
        for(Cart_Product cart_product : cart_products){
            total += cart_product.getProduct().getPrice() * cart_product.getQuantity();
            totalDiscount += cart_product.getQuantity() * (cart_product.getProduct().getPrice() - (cart_product.getProduct().getPrice()-(cart_product.getProduct().getPrice()*cart_product.getProduct().getDiscountPercent())));
        }


        int amount= (int)(total-totalDiscount);
        String payMent = paymentService.createPayment(amount*100000);

        order.setPaid(false);
        order.setOrderDate(new Date());
        order.setTotal(total-totalDiscount);
        order.setCart(cartService.findCartById(id));
//        order.setId(orderService.getMaxOrderID() + 1);
        orderService.save(order);
        return "redirect:"+payMent;
    }

}
