package hcmute.springbootdemo.Controller.Admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hcmute.springbootdemo.Entity.Category;
import hcmute.springbootdemo.Service.ICategoryService;

@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {
	@Autowired
	ICategoryService categoryService;
	
	@GetMapping(value = "")
	public String index(ModelMap model) {
		model.addAttribute("active", "category");
		model.addAttribute("category", new Category());
		List<Category> list = categoryService.findAll();
		model.addAttribute("list", list);
        return "admin/category";
	}
	@PostMapping("/save")
    public String saveCategory(RedirectAttributes redirectAttributes,
    		@Valid @ModelAttribute("category") Category category, BindingResult result) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Thao tác thành công!");
        return "redirect:/admin/category";
    }
	@GetMapping(value = "delete/{id}")
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("id") int id) {
		categoryService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "Thao tác thành công!");
		return "redirect:/admin/category";
	}
}
