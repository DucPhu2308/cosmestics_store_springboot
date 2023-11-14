package hcmute.springbootdemo.Controller.Admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import hcmute.springbootdemo.Entity.Brand;
import hcmute.springbootdemo.Service.IBrandService;

@Controller
@RequestMapping(value = "/admin/brand-category")
public class BrandCategoryController {
	@Autowired
	IBrandService brandService;
	
	@RequestMapping(value = "")
	public String index(ModelMap model)
	{
		model.addAttribute("active", "brand");
		List<Brand> listBrands = brandService.findAll();
		model.addAttribute("listBrands", listBrands);
		return "admin/brand_category";
	}
	@PostMapping(value = "saveBrand")
	public String saveBrand(RedirectAttributes redirectAttributes, @RequestParam("name") String name)
	{
		Brand brand = new Brand();
		brand.setName(name);
		brandService.save(brand);
		redirectAttributes.addFlashAttribute("message", "Thao tác thành công!");
		return "redirect:/admin/brand-category";
	}
}
