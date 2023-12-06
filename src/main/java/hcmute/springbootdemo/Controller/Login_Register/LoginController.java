package hcmute.springbootdemo.Controller.Login_Register;

import hcmute.springbootdemo.Entity.User;
import hcmute.springbootdemo.Service.IUserService;
import hcmute.springbootdemo.Service.impl.CartServiceImpl;
import hcmute.springbootdemo.Service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping(path= "/login")
public class LoginController {

    @Autowired
    IUserService userService;
    @Autowired
    CartServiceImpl cartService;
    @Autowired
    ProductServiceImpl productService;

    @GetMapping(value="")
    public String login (){
        return "login/login";
    }


    @PostMapping(value= "/checklogin")
    public String checkLogin(@RequestParam("phoneNumber") String phoneNumber,
                             @RequestParam("password") String password,
                             RedirectAttributes redirectAttributes,
                             HttpSession session,
                             ModelMap modelMap){

        if (userService.checklogin(phoneNumber, password)) {
            Optional<User> user_login = userService.findUserByPhone(phoneNumber);
            User user = user_login.get();
            if (user.getActive() == false) {
                redirectAttributes.addFlashAttribute("error", "Tài khoản đã bị khóa");
                return "redirect:/login";
            }
            session.setAttribute("user", user);
            session.setAttribute("user_id", user.getId());
            Authentication authentication = new UsernamePasswordAuthenticationToken(phoneNumber, password);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            session.setAttribute("image_user",user.getAvatarLink());
            session.setAttribute("FirstName",user.getFirstName());
            session.setAttribute("LastName",user.getLastName());

            if (user.getIsAdmin() == true) {
                return "redirect:/admin/";
            }

            return "redirect:/" ;
        }
        else {
            redirectAttributes.addFlashAttribute("error", "Sai tài khoản hoặc mật khẩu");
            return "redirect:/login";
        }
        
    }

    @GetMapping(value="/fill_email")
    public String fill_email(){
        return "login/fill_email";
    }

    @GetMapping(value="fill_code")
    public String fill_code(){
        return "login/fill_code";
    }

}
