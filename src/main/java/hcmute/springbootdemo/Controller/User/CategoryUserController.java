package hcmute.springbootdemo.Controller.User;

import hcmute.springbootdemo.Repository.CategoryRepository;
import hcmute.springbootdemo.Service.IBrandService;
import hcmute.springbootdemo.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path="/category")
public class CategoryUserController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    IProductService productService;

    @Autowired
    IBrandService brandService;

    @GetMapping(value=" ")
    public String category(ModelMap modelMap){
        modelMap.addAttribute("list_category", categoryRepository.findAll());

        modelMap.addAttribute("list_brand", brandService.findAll());

        modelMap.addAttribute("list_product_category", productService.findAll());

        return "user/category";
    }

    @GetMapping(value="/{id}")
    public String productByCategory (ModelMap modelMap, @PathVariable("id") int id, HttpSession session){
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
