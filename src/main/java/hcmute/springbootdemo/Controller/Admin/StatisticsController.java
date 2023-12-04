package hcmute.springbootdemo.Controller.Admin;

import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hcmute.springbootdemo.Entity.Brand;
import hcmute.springbootdemo.Entity.Cart;
import hcmute.springbootdemo.Entity.Cart_Product;
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
    public String monthly(ModelMap model, @RequestParam(required = false, defaultValue = "2023") int year){
        model.addAttribute("active", "statistics");
        model.addAttribute("year", year);
        List<Order> listOrder = orderService.findAll();
        model.addAttribute("revenueByMonth", calculateRevenueByMonth(listOrder, year));
        
        Map<Integer, Map<Brand, Double>> brandSales = calculateBrandSales(listOrder, year);
        // convert to Map<Brand, Map<Month, Revenue>>
        Map<Brand, Map<Integer, Double>> newBrandSales = new HashMap<>();
            brandSales.forEach((month, brandMap) -> {
            for (Brand brand : brandMap.keySet()) {
                newBrandSales.put(brand, new HashMap<>());
                newBrandSales.get(brand).put(month, brandMap.get(brand));
            }
        });
        System.out.println(newBrandSales);
        // calculate total revenue by brand and sort from highest to lowest
        Map<Brand, Double> totalBrandSales = newBrandSales.entrySet().stream()
                .collect(
                    Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().values().stream().mapToDouble(Double::doubleValue).sum()
                    )
                )
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                    Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                    )
                );
        // push to view brand sales by month of top 3 brand has highest total revenue
        List<Brand> top3Brand = totalBrandSales.keySet().stream().limit(3).collect(Collectors.toList());
        int n = top3Brand.size() < 3 ? top3Brand.size() : 3;
        for (int i=0; i<n; i++) {
            Brand brand = top3Brand.get(i);
            Map<Integer, Double> revenueByMonth = newBrandSales.get(brand);
            revenueByMonth = fillZeroForMonth(revenueByMonth);
            model.addAttribute("brandSales" + (i+1), revenueByMonth);
            model.addAttribute("brand" + (i+1), brand);
        }

        return "admin/statistics/monthly";
    }
    private static Map<Integer, Double> fillZeroForMonth(Map<Integer, Double> map) {
        for (int i = 1; i <= 12; i++) {
            if (!map.containsKey(i)) {
                map.put(i, 0.0);
            }
        }
        return map;
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
    private Map<Integer, Map<Brand, Double>> calculateBrandSales(List<Order> orders, int year) {
        // calculate revenue by brand
        Calendar calendar = Calendar.getInstance();
        Map<Integer, List<Order>> orderByMonth = orders.stream()
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
                            Collectors.toList()
                    )
                );
        // fill 0 for month has no revenue
        // for (int i = 1; i <= 12; i++) {
        //     if (!orderByMonth.containsKey(i)) {
        //         orderByMonth.put(i, new ArrayList<>());
        //     }
        // }

        Map<Integer, Map<Brand, Double>> result = new HashMap<>();
        for (int month : orderByMonth.keySet()) {
            Map<Brand, Double> revenueByBrand = orderByMonth.get(month).stream()
                    .flatMap(order -> {
                        Cart cart = order.getCart();
                        List<Cart_Product> cart_products = cart_productService.findCart_ProductsByCartId(cart.getId());
                        return cart_products.stream();
                    })
                    .collect(
                        Collectors.groupingBy(
                                cart_product -> {
                                    return cart_product.getProduct().getBrand();
                                },
                                Collectors.summingDouble(cart_product -> cart_product.getProduct().getPrice() * cart_product.getQuantity())
                        )
                    )
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByValue()) // Sắp xếp theo giá trị (tổng tiền)
                    .collect(
                        Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1, // Nếu có các giá trị giống nhau, giữ lại giá trị đầu tiên
                            LinkedHashMap::new // Giữ lại thứ tự sắp xếp của Map
                        )
                    );
            result.put(month, revenueByBrand);
        }
        
        return result;
    }
    private static Float calculateBrandSalesByCart(Cart cart, int brandId) {
        return cart.getCart_products().stream()
                .filter(cart_product -> cart_product.getProduct().getBrand().getId() == brandId)
                .map(cart_product -> cart_product.getProduct().getPrice() * cart_product.getQuantity())
                .collect(Collectors.summingDouble(null)).floatValue();
    }
}
