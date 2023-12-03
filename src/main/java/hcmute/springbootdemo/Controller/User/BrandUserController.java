package hcmute.springbootdemo.Controller.User;

import hcmute.springbootdemo.Service.impl.BrandServiceImpl;
import hcmute.springbootdemo.Service.impl.CategoryServiceImpl;
import hcmute.springbootdemo.Service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path="/brand/")
public class BrandController {

    @Autowired
    BrandServiceImpl brandService;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    ProductServiceImpl productService;

    @GetMapping(value="{id}")
    public String productByBrand (ModelMap modelMap, @PathVariable("id") int id, HttpSession session){
        modelMap.addAttribute("list_category", categoryService.findAll());
        modelMap.addAttribute("list_brand", brandService.findAll());
        modelMap.addAttribute("list_product_category", productService.findProductByCategoryAndBrand((int)session.getAttribute("category_id"), id));
        return "user/category";
    }
}
