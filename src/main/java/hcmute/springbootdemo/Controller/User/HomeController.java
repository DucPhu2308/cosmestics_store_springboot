package hcmute.springbootdemo.Controller.User;

import hcmute.springbootdemo.Repository.Cart_ProductRepository;
import hcmute.springbootdemo.Repository.CategoryRepository;
import hcmute.springbootdemo.Service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="")
public class HomeController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    Cart_ProductRepository cart_productRepository;

    @Autowired
    IProductService productService;

    @GetMapping(value="")
    public String home (ModelMap model, HttpSession session){
        model.addAttribute("latestProduct", productService.get10Newest());    
        model.addAttribute("bestProduct", productService.get10Best());
//        session.setAttribute("CountProduct",cart_productRepository.count());
        return "user/main";
    }




    @GetMapping(value="/checkout")
    public String checkout(HttpSession session){
        session.removeAttribute("username");
        session.removeAttribute("user_id");
        session.removeAttribute("cart_id");
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/";
    }

}
