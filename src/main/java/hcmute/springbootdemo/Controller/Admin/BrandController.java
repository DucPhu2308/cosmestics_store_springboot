package hcmute.springbootdemo.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hcmute.springbootdemo.Entity.Brand;
import hcmute.springbootdemo.Service.IBrandService;

@Controller
@RequestMapping(value = "/admin/brand")
public class BrandController {
	@Autowired
	IBrandService brandService;
	
	@RequestMapping(value = "")
	public String index(ModelMap model)
	{
		model.addAttribute("active", "brand");
		List<Brand> listBrands = brandService.findAll();
		model.addAttribute("listBrands", listBrands);
		return "admin/brand";
	}
	@PostMapping(value = "save")
	public String saveBrand(RedirectAttributes redirectAttributes,
			@RequestParam(name="id", required=false) Integer id, @RequestParam("name") String name)
	{
		Brand brand = new Brand();
		if (id != null)
			brand.setId(id);
		brand.setName(name);
		brandService.save(brand);
		redirectAttributes.addFlashAttribute("message", "Thao tác thành công!");
		return "redirect:/admin/brand";
	}
	@GetMapping(value = "delete/{id}")
	public String deleteBrand(RedirectAttributes redirectAttributes, @PathVariable("id") int id) {
		brandService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "Thao tác thành công!");
		return "redirect:/admin/brand";
	}
}
