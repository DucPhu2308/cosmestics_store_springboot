package hcmute.springbootdemo.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/product")
public class ProductController {
	@RequestMapping(value = "")
	public String index(ModelMap model)
	{
		model.addAttribute("active", "product");
		return "admin/product";
	}
	@GetMapping(value = "edit")
	public String getEdit(ModelMap model)
	{
		model.addAttribute("active", "product");
		return "admin/edit_product";
	}
}
