package hcmute.springbootdemo.Controller.User;

import hcmute.springbootdemo.Entity.Cart;
import hcmute.springbootdemo.Entity.Cart_Product;
import hcmute.springbootdemo.Entity.Product;
import hcmute.springbootdemo.Entity.User;
import hcmute.springbootdemo.Repository.Cart_ProductRepository;
import hcmute.springbootdemo.Service.impl.CartServiceImpl;
import hcmute.springbootdemo.Service.impl.ProductServiceImpl;
import hcmute.springbootdemo.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path="cart")
public class CartController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    Cart_ProductRepository cart_productRepository;

    @Autowired
    CartServiceImpl cartService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value=" ")
    public String cart( ModelMap modelMap,HttpSession session){
        if(session.getAttribute("cart_id")==null){
            session.setAttribute("cart_id", 0);
            int user_id = (int) session.getAttribute("user_id");
            List<Cart> listCart = cartService.findCartByUserId(user_id);
            modelMap.addAttribute("listCartUser", listCart);
        }
        else{
            int cart_id = (int) session.getAttribute("cart_id");


            if (cart_id!=0){
                List<Cart_Product> listCartProduct = cart_productRepository.findCart_ProductsByCartId(cart_id);

                int user_id = (int) session.getAttribute("user_id");
                List<Cart> listCart = cartService.findCartByUserId(user_id);
                modelMap.addAttribute("listCartUser", listCart);


                if(listCartProduct.size()==0){
                    modelMap.addAttribute("totalPrice", "0");
                }
                else{
                    modelMap.addAttribute("listCartProduct", listCartProduct);
                    float totalPrice = cart_productRepository.sumTotal();
                    modelMap.addAttribute("totalPrice", totalPrice);
                    modelMap.addAttribute("listCartProduct", listCartProduct);

                }
            }
        }
        return "user/cart";
    }

    @PostMapping(value="getProduct")
    public String getProduct( ModelMap modelMap,HttpSession session,
                              @RequestParam("cart_user")int cart_id){
        session.setAttribute("cart_id", cart_id);
        return "redirect:/cart";
    }
    @GetMapping(value="/add")
    public String addCart(ModelMap modelMap, HttpSession session){
        modelMap.addAttribute("addCart", new Cart());
        int user_id = (int) session.getAttribute("user_id");
        String firstName= userService.findById(user_id).get().getFirstName();
        String lastName= userService.findById(user_id).get().getLastName();

        modelMap.addAttribute("firstName", firstName);
        modelMap.addAttribute("lastName", lastName);

        return "user/addCart";
    }
    @PostMapping(value="/add")
    public String addCart(HttpSession session, @ModelAttribute("addCart") Cart cart){
        int user_id = (int) session.getAttribute("user_id");
        User user = userService.findById(user_id).get();
        Cart newCart = new Cart();
        newCart.setUser(user);
        newCart.setName(cart.getName());
        newCart.setActive(true);
        cartService.save(newCart);
        return "redirect:/cart";
    }



    @PostMapping(value="/delete/{id}")
    public String deleteCartProduct(HttpSession session, ModelMap modelMap, @PathVariable("id") int id){
        cart_productRepository.deleteById(id);
        return "redirect:/cart";
    }

    @PostMapping(value="/delete_cart/{id}")
    public String deleteCart(HttpSession session, ModelMap modelMap, @PathVariable("id") int id){
        cartService.deleteById(id);
        return "redirect:/cart";
    }

}
