package hcmute.springbootdemo.Controller.Login_Register;

import hcmute.springbootdemo.Entity.User;
import hcmute.springbootdemo.Service.IUserService;
import hcmute.springbootdemo.Service.impl.CartServiceImpl;
import hcmute.springbootdemo.Service.impl.EmailServiceImpl;
import hcmute.springbootdemo.Service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @Autowired
    EmailServiceImpl emailService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value="")
    public String login (){
        return "login/login";
    }


    @PostMapping(value= "/checklogin")
    public String checkLogin(@RequestParam("Email") String email,
                             @RequestParam("password") String password,
                             @RequestParam(value = "remember-me", required = false) String remember_me,
                             RedirectAttributes redirectAttributes,
                             HttpSession session,
                             ModelMap modelMap){

        if (userService.checklogin(email, password)) {
            System.out.println("Remember me: " + remember_me);
            Optional<User> user_login = userService.findUserByEmail(email);
            System.out.println(email);
            User user = user_login.get();
            if (user.getActive() == false) {
                redirectAttributes.addFlashAttribute("error", "Tài khoản đã bị khóa");
                return "redirect:/login";
            }
            session.setAttribute("user", user);
            session.setAttribute("user_id", user.getId());
            Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            session.setAttribute("image_user",user.getAvatarLink());
            session.setAttribute("FirstName",user.getFirstName());
            session.setAttribute("LastName",user.getLastName());

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

    @PostMapping(value="/fill_email")
    public String fill_email(@RequestParam("email") String email,
                             RedirectAttributes redirectAttributes,
                             HttpSession session){
        Optional<User> userOpt = userService.findUserByEmail(email);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            String code = emailService.generateRandomCode();
            user.setPasswordHashed(passwordEncoder.encode(code));
            userService.save(user);
            // send email
            String subject = "[Ori Shop] Quên mật khẩu";
            String text = "Mật khẩu mới của bạn là: " + code + "\n" +
                    "Hãy đổi mật khẩu ngay khi có thể.";
            emailService.sendSimpleMessage(email,subject,text);

            return "redirect:/login";
        }
        else{
            redirectAttributes.addFlashAttribute("error","Email chưa được đăng ký");
            return "redirect:/login/fill_email";
        }
    }

    @GetMapping(value="fill_code")
    public String fill_code(){
        return "register/fill_code";
    }

}
