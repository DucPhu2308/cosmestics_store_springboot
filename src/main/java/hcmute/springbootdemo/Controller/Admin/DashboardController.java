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

@Controller
@RequestMapping(value = "/admin")
public class DashboardController {
	@Autowired
	IOrderService orderService;

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
		model.addAttribute("revenueByMonth", calculateRevenueByMonth(listOrder));
		return "admin/index";
	}
	 private static Map<Integer, Double> calculateRevenueByMonth(List<Order> orders) {
        return orders.stream().collect(
				Collectors.groupingBy(
						order -> order.getOrderDate().getMonth() + 1,
						Collectors.summingDouble(Order::getTotal))
				);
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
