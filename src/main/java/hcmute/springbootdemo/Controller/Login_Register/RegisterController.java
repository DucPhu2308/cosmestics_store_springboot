package hcmute.springbootdemo.Controller.Login_Register;


import hcmute.springbootdemo.Entity.User;
import hcmute.springbootdemo.Repository.UserRepository;
import hcmute.springbootdemo.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.lang.reflect.Type;

@Controller
@RequestMapping(path="/register/")
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserService userService;

    @GetMapping(value="")
    public String register(ModelMap modelMap){
        modelMap.addAttribute("new_user",new User());
        return "register/register";
    }

    @PostMapping(value="/register2")
    public String register2(ModelMap modelMap,
                            @Valid @ModelAttribute("new_user")User user){
        try{
            String phoneNumber = user.getPhone();
            String password = user.getPasswordHashed();
            if(phoneNumber.isEmpty() || password.isEmpty()){
                modelMap.addAttribute("error","Vui lòng nhập đầy đủ thông tin");
                return "redirect:/register/";
            }
            if(userRepository.findUserByPhone(phoneNumber).isPresent()){
                modelMap.addAttribute("error","Số điện thoại đã được sử dụng");
                return "redirect:/register/";
            }
            userRepository.save(user);
            return"redirect:/login/";
        }catch(Exception e){
            e.printStackTrace();

            return "register/register";
        }
    }
}