package hcmute.springbootdemo.Controller.User;


import hcmute.springbootdemo.Entity.*;
import hcmute.springbootdemo.Repository.*;
import hcmute.springbootdemo.Service.impl.CartServiceImpl;
import hcmute.springbootdemo.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path="/product")
public class ProductUserController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    Cart_ProductRepository cart_productRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CartServiceImpl cartService;

    @GetMapping(value="/{id}")
    public String productUser(ModelMap modelMap, @PathVariable("id") int id, HttpSession session){

        Product product = productRepository.findById(id).get();

        if(product.getAvailable()){
            modelMap.addAttribute("available", "Còn hàng");
        }
        else{
            modelMap.addAttribute("available", "Hết hàng");
        }

        String userID = session.getAttribute("user_id").toString();

        int user_id = 0;
        if(userID == null){
            modelMap.addAttribute("user_id", 0);
        }
        else{
            user_id = (int) session.getAttribute("user_id");
            modelMap.addAttribute("user_id", user_id);
        }

        List<Cart> listCart = cartService.findCartByUserId(user_id);

        if(listCart !=null ){
            modelMap.addAttribute("listCart", listCart);
        }
        else{
            modelMap.addAttribute("listCart", "không có giỏ hàng");
        }

        float price=0;

        if(product.getDiscountPercent()!=0){
            price= product.getPrice()-(product.getDiscountPercent()* product.getPrice());
        }
        else{
            price= product.getPrice();
        }

        modelMap.addAttribute("product", product);
        modelMap.addAttribute("productId", id);
        modelMap.addAttribute("discount", product.getDiscountPercent());



        modelMap.addAttribute("discountStart", product.getDiscountStart());
        modelMap.addAttribute("discountEnd", product.getDiscountEnd());

        modelMap.addAttribute("product_discounted", price);
        modelMap.addAttribute("product_price", product.getPrice());

        modelMap.addAttribute("cart_product", new Cart_Product());
        modelMap.addAttribute("post_review",new Review());

        List<Review> product_review= reviewRepository.findReviewByProductId(id);
        modelMap.addAttribute("product_review", product_review);



        return "user/product";
    }

    //Phần này chưa hoàn thành được cần thời gian để suy nghĩ
    @PostMapping(value="/{id}/product_to_cart")
    public String insertProductToCart(HttpSession session,
                                      @ModelAttribute("cart_product") Cart_Product cartproduct,
                                      @PathVariable("id") int id,
                                      ModelMap modelMap){


        Product product = productRepository.findById(id).get();

        cartproduct.setProduct(product);

        // tổng tiền của sản phẩm đó sau khi thêm vào giỏ hàng
        float total = cartproduct.getQuantity() * product.getPrice() - (cartproduct.getQuantity() * product.getPrice() * product.getDiscountPercent());
        cartproduct.setTotalPrice(total);


        cart_productRepository.save(cartproduct);

//        cách hiển thị thông báo thành công trên alert

        session.setAttribute("CountProduct",cart_productRepository.count());

        session.setAttribute("success", "Thêm sản phẩm vào giỏ hàng thành công");

        return "redirect:/product/{id}";
    }

    @PostMapping(value="/{id}/review1")
    public String contact(@ModelAttribute("post_review") Review review,
                          ModelMap modelMap, @PathVariable(value = "id") int id ,
                          HttpSession session){
        Product product= productRepository.findById(id).get();
        User user = userRepository.findUserById((int) session.getAttribute("user_id"));

        review.setProduct(product);
        review.setUser(user);

        reviewRepository.save(review);

        modelMap.addAttribute("success", "Đánh giá thành công");

        return "redirect:/product/{id}";
    }
}
