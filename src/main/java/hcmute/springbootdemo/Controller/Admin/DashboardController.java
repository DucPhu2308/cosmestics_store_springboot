package hcmute.springbootdemo.Controller.Admin;

import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.springbootdemo.Entity.Order;
import hcmute.springbootdemo.Service.IOrderService;
import hcmute.springbootdemo.Service.IReviewService;
import hcmute.springbootdemo.Service.IUserService;

@Controller
@RequestMapping(value = "/admin")
public class DashboardController {
	@Autowired
	IOrderService orderService;

	@Autowired
	IUserService userService;

	@Autowired
	IReviewService reviewService;

	@RequestMapping(value = "")
	public String index(ModelMap model)
	{
		model.addAttribute("active", "home");

		// Thống kê 30 ngày gần nhất
		// Lấy ngày hiện tại
		Date today = new Date();
		// Lấy ngày 30 ngày trước
		Date dateBefore = new Date(today.getTime() - 30 * 24 * 3600 * 1000L);
		// List<Order> listOrder = orderService.findByOrderDateBetween(dateBefore, today);
		List<Order> listOrder = orderService.findAll();
		model.addAttribute("orderCount", listOrder.size());
		model.addAttribute("revenue", getRevenue(listOrder));	
		model.addAttribute("userCount", userService.count());
		model.addAttribute("reviewCount", reviewService.count());
		model.addAttribute("newOrder", orderService.findTop10NewestOrder());
		model.addAttribute("newReview", reviewService.findTop10NewestReview());
		return "admin/index";
	}
	float getRevenue(List<Order> listOrder)
	{
		float revenue = 0;
		for (Order order : listOrder)
		{
			revenue += order.getTotal();
		}
		return revenue;
	}
}
