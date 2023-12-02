package hcmute.springbootdemo.Controller.User;

import hcmute.springbootdemo.Entity.Category;
import hcmute.springbootdemo.Entity.Product;
import hcmute.springbootdemo.Repository.Cart_ProductRepository;
import hcmute.springbootdemo.Repository.CategoryRepository;
import hcmute.springbootdemo.Service.IBrandService;
import hcmute.springbootdemo.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/category")
public class CategoryUserController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    IProductService productService;

    @Autowired
    IBrandService brandService;

    @Autowired
    Cart_ProductRepository cart_productRepository;

    @GetMapping(value=" ")
    public String category(ModelMap modelMap, HttpSession session){

        List<Category> listCategory = categoryRepository.findAll();
        List<Integer> listCountProduct = new ArrayList<>();
        for (Category category: listCategory) {
            int countProduct = productService.countProductsByCategoryId(category.getId());
            listCountProduct.add(countProduct);
        }
        modelMap.addAttribute("listCountProduct", listCountProduct);

        modelMap.addAttribute("list_category", categoryRepository.findAll());

        modelMap.addAttribute("list_brand", brandService.findAll());

        session.setAttribute("CountProduct",cart_productRepository.count());

        modelMap.addAttribute("list_product_category", productService.findAll());

        return "user/category";
    }

    @GetMapping(value="/{id}")
    public String productByCategory (ModelMap modelMap, @PathVariable("id") int id, HttpSession session){

        List<Category> listCategory = categoryRepository.findAll();
        List<Integer> listCountProduct = new ArrayList<>();
        for (Category category: listCategory) {
            int countProduct = productService.countProductsByCategoryId(category.getId());
            listCountProduct.add(countProduct);
        }

        modelMap.addAttribute("listCountProduct", listCountProduct);
        modelMap.addAttribute("list_category", categoryRepository.findAll());
        modelMap.addAttribute("list_brand", brandService.findAll());
        modelMap.addAttribute("list_product_category", productService.findProductByCategory(id));
        session.setAttribute("category_id", id);
        return "user/category";
    }

    @GetMapping(value="/brand/{id}")
    public String productByBrand (ModelMap modelMap, @PathVariable("id") int id, HttpSession session){
        modelMap.addAttribute("list_category", categoryRepository.findAll());
        modelMap.addAttribute("list_brand", brandService.findAll());
        modelMap.addAttribute("list_product_category", productService.findProductByCategoryAndBrand((int)session.getAttribute("category_id"), id));
        return "user/category";
    }
}
