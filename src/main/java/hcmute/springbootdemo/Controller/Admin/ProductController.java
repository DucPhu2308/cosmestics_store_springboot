package hcmute.springbootdemo.Controller.Admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import hcmute.springbootdemo.Entity.Brand;
import hcmute.springbootdemo.Entity.Category;
import hcmute.springbootdemo.Entity.Product;
import hcmute.springbootdemo.Service.IBrandService;
import hcmute.springbootdemo.Service.ICategoryService;
import hcmute.springbootdemo.Service.IProductService;

@Controller
@RequestMapping(value = "/admin/product")
public class ProductController {
	@Autowired
	IProductService productService;
	
	@Autowired
	IBrandService brandService;
	
	@Autowired
	ICategoryService categoryService;
	
	@RequestMapping(value = "")
	public String index(ModelMap model)
	{
		model.addAttribute("active", "product");
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		model.addAttribute("product", new Product());
		List<Brand> brands = brandService.findAll();
		model.addAttribute("brands", brands);
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "admin/product";
	}
	@PostMapping("/save")
	public String save(RedirectAttributes redirectAttributes,
    		@Valid @ModelAttribute("product") Product product, BindingResult result) {
		productService.save(product);
		redirectAttributes.addFlashAttribute("message", "Thao tác thành công!");
        return "redirect:/admin/product";
	}
	@GetMapping("/delete/{id}")
	public String delete(RedirectAttributes redirectAttributes, @ModelAttribute("id") int id) {
		productService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "Thao tác thành công!");
		return "redirect:/admin/product";
	}

	@GetMapping("/images/{id}")
	public String getImages(ModelMap model, @PathVariable("id") int id) {
		model.addAttribute("active", "product");
		Product product = productService.findById(id).get();
		model.addAttribute("product", product);
		return "admin/product_images";
	}
}
