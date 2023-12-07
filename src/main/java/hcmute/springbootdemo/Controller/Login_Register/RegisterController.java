package hcmute.springbootdemo.Controller.Login_Register;


import hcmute.springbootdemo.Entity.User;
import hcmute.springbootdemo.Repository.UserRepository;
import hcmute.springbootdemo.Service.IUserService;
import hcmute.springbootdemo.Service.impl.EmailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Random;

@Controller
@RequestMapping(path="/register")
public class RegisterController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserService userService;

    @Autowired
    EmailServiceImpl emailService;

    @GetMapping(value="")
    public String register(ModelMap modelMap){
        modelMap.addAttribute("new_user",new User());
        return "register/register";
    }

    @PostMapping(value="/register2")
    public String register2(ModelMap modelMap,
                            @Valid @ModelAttribute("new_user")User user, HttpSession session,
                            @RequestParam("re-password") String repassword,
                            RedirectAttributes redirectAttributes){
        try{
            String email = user.getEmail();
            String password = user.getPasswordHashed();
            if(email.isEmpty() || password.isEmpty()){
                modelMap.addAttribute("error","Vui lòng nhập đầy đủ thông tin");
                return "redirect:/register/";
            }
            if(userRepository.findUserByEmail(email).isPresent()){
                modelMap.addAttribute("error","Email này đã được sử dụng");
                return "redirect:/register/";
            }
            if(repassword.equals(password)==false){
                redirectAttributes.addFlashAttribute("error","Mật khẩu không khớp");
                return "redirect:/register/";
            }
            user.setActive(false);
            user.setIsAdmin(false);
            user.setFirstName("New user"); 
            user.setLastName("");
            // hash password
            user.setPasswordHashed(passwordEncoder.encode(user.getPasswordHashed()));

            // generate code
            user.setCode(emailService.generateRandomCode());
            userRepository.save(user);

            // save user to session
            session.setAttribute("user",user);

            // send email
            String subject = "Xác nhận đăng ký tài khoản";
            String text = "Mã xác nhận của bạn là: " + user.getCode();
            emailService.sendSimpleMessage(email,subject,text);

            // redirectAttributes.addFlashAttribute("message","Đăng ký thành công!");
            return"redirect:/register/verify";
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("error","Đăng ký thất bại");
            return "redirect:/register/";
        }
    }

    @GetMapping(value="/verify")
    public String verify(ModelMap modelMap){
        return "register/fill_code";
    }

    @PostMapping(value="/verify")
    public String verify(ModelMap modelMap,
                         @RequestParam("authcode") String code,
                         HttpSession session,
                         RedirectAttributes redirectAttributes){
        try{
            User user = (User) session.getAttribute("user");
            if(user.getCode().equals(code)){
                user.setActive(true);
                user.setCode("");
                userRepository.save(user);
                session.setAttribute("user",user);
                return "redirect:/login/";
            }
            else{
                redirectAttributes.addFlashAttribute("error","Mã xác nhận không đúng");
                return "redirect:/register/verify";
            }
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("error","Xác nhận thất bại");
            return "redirect:/register/verify";
        }
    }

    public static String randomString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            int index = random.nextInt(AlphaNumericString.length());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}
