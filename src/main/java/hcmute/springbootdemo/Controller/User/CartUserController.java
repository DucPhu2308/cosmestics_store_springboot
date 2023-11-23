package hcmute.springbootdemo.Controller.User;

import hcmute.springbootdemo.Entity.Cart_Product;
import hcmute.springbootdemo.Repository.Cart_ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path="/user/cart")
public class CartUserController {

    @Autowired
    Cart_ProductRepository cart_productRepository;

    @GetMapping(value=" ")
    public String cart(HttpSession session, ModelMap modelMap){
        List<Cart_Product> listCartProduct = cart_productRepository.findAll();
        int user_id= (int) session.getAttribute("user_id");


        float totalPrice = cart_productRepository.sumTotal();
        modelMap.addAttribute("totalPrice", totalPrice);
        modelMap.addAttribute("listCartProduct", listCartProduct);

        return "user/cart";

    }

    @PostMapping(value="/delete/{id}")
    public String deleteCartProduct(HttpSession session, ModelMap modelMap, @PathVariable("id") int id){
        cart_productRepository.deleteById(id);
        return "redirect:/user/cart";
    }

}
