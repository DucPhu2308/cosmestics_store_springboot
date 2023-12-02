package hcmute.springbootdemo.Controller.Admin;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hcmute.springbootdemo.Entity.Brand;
import hcmute.springbootdemo.Entity.Category;
import hcmute.springbootdemo.Entity.Image;
import hcmute.springbootdemo.Entity.Product;
import hcmute.springbootdemo.Service.IBrandService;
import hcmute.springbootdemo.Service.ICategoryService;
import hcmute.springbootdemo.Service.IImageService;
import hcmute.springbootdemo.Service.IProductService;
import hcmute.springbootdemo.Service.IStorageService;

@Controller
@RequestMapping(value = "/admin/product")
public class ProductController {
	@Autowired
	IProductService productService;

	@Autowired
	IBrandService brandService;

	@Autowired
	ICategoryService categoryService;

	@Autowired
	IImageService imageService;

	@Autowired
	IStorageService storageService;

	@RequestMapping(value = "")
	public String index(ModelMap model) {
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
		System.out.println(product.getDescription());
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

	@PostMapping("/images/{id}")
	public String saveImages(RedirectAttributes redirectAttributes,
			@RequestParam("image") MultipartFile img, @PathVariable("id") int id) {
		try {
			if (img.isEmpty()) {
				redirectAttributes.addFlashAttribute("error", "Thao tác thất bại!");
			} else {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				Image image = new Image();
				image.setProduct(productService.findById(id).get());
				image.setImageLink("product/" + storageService.getSorageFilename(img, uuString));
				storageService.store(img, image.getImageLink());
				imageService.save(image);
				redirectAttributes.addFlashAttribute("message", "Thao tác thành công!");
			}

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
		}
		return "redirect:/admin/product/images/" + id;
	}

	@GetMapping("/image-delete/{id}")
	public String deleteImages(RedirectAttributes redirectAttributes, @PathVariable("id") int id) {
		try {
			// System.out.println(imageService.findAll());
			Image image = imageService.findById(id).get();
			storageService.delete(image.getImageLink());
			imageService.deleteById(id);
			redirectAttributes.addFlashAttribute("message", "Thao tác thành công!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
		}
		return "redirect:/admin/product/images/" + imageService.findById(id).get().getProduct().getId();
	}
}
