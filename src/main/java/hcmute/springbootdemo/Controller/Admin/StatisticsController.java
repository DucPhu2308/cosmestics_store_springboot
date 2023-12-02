package hcmute.springbootdemo.Controller.Admin;

import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.springbootdemo.Entity.Brand;
import hcmute.springbootdemo.Entity.Cart;
import hcmute.springbootdemo.Entity.Order;
import hcmute.springbootdemo.Service.ICart_Product;
import hcmute.springbootdemo.Service.IOrderService;

@Controller
@RequestMapping(value="/admin/statistics")
public class StatisticsController {
    @Autowired
    IOrderService orderService;

    @Autowired
    ICart_Product cart_productService;

    @GetMapping(value="monthly")
    public String monthly(ModelMap model){
        model.addAttribute("active", "statistics");
        List<Order> listOrder = orderService.findAll();
        model.addAttribute("revenueByMonth", calculateRevenueByMonth(listOrder, 2023));
        return "admin/statistics/monthly";
    }
    private static Map<Integer, Double> calculateRevenueByMonth(List<Order> orders, int year) {
        Calendar calendar = Calendar.getInstance();
        Map<Integer, Double> result = orders.stream()
                .filter(order -> {
                    calendar.setTime(order.getOrderDate());
                    return calendar.get(Calendar.YEAR) == year && order.getPaid();
                })
                .collect(
                    Collectors.groupingBy(
                            order -> {
                                calendar.setTime(order.getOrderDate());
                                return calendar.get(Calendar.MONTH) + 1;
                            },
                            Collectors.summingDouble(Order::getTotal))
				);
        // fill 0 for month has no revenue
        for (int i = 1; i <= 12; i++) {
            if (!result.containsKey(i)) {
                result.put(i, 0.0);
            }
        }
        return result;
    }
    private static Map<Integer, Double> calculateBrandSales(List<Order> orders, int year) {
        // calculate revenue by brand
        Calendar calendar = Calendar.getInstance();
        
        return null;
    }
    private static Float calculateBrandSalesByCart(Cart cart, int brandId) {
        return cart.getCart_products().stream()
                .filter(cart_product -> cart_product.getProduct().getBrand().getId() == brandId)
                .map(cart_product -> cart_product.getProduct().getPrice() * cart_product.getQuantity())
                .collect(Collectors.summingDouble(null)).floatValue();
    }
}
