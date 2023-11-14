package hcmute.springbootdemo.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class DashboardController {
	@RequestMapping(value = "/")
	public String index()
	{
		return "admin/index";
	}
}
