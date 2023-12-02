package hcmute.springbootdemo.Controller.Login_Register;


import hcmute.springbootdemo.Entity.User;
import hcmute.springbootdemo.Service.IUserService;
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

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping(path= "/login")
public class LoginController {

    @Autowired
    IUserService userService;
    @GetMapping(value="")
    public String login (){
        return "login/login";
    }


    @PostMapping(value= "/checklogin")
    public String checkLogin(@RequestParam("phoneNumber") String phoneNumber,
                             @RequestParam("password") String password,
                             HttpSession session,
                             ModelMap modelMap){
                        
        if(userService.checklogin(phoneNumber,password)) {
            Optional<User> user_login = userService.findUserByPhone(phoneNumber);
            User user = user_login.get();
            session.setAttribute("user_id", user.getId());
            Authentication authentication = new UsernamePasswordAuthenticationToken(phoneNumber, password);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/" ;
        }
        else {
            modelMap.addAttribute("error","Sai tài khoản hoặc mật khẩu");
            return "login/login";
        }
        
    }
}
