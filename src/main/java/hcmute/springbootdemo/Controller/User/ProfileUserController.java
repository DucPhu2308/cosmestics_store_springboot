package hcmute.springbootdemo.Controller.User;

import hcmute.springbootdemo.Entity.User;
import hcmute.springbootdemo.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/profile_user/")
public class ProfileUserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value="{id}")
    public String profile_user(ModelMap modelMap, @PathVariable("id") int id){
        User user = userService.findById(id).get();
        modelMap.addAttribute("user", user);
        return "user/profile_user";
    }

    @PostMapping(value="update_user")
    public String update( @ModelAttribute("user") User user, HttpSession session){
        System.out.println(user.getFirstName() + user.getLastName() + user.getPhone() + user.getPasswordHashed());
        int user_id = (int) session.getAttribute("user_id");
        String password = userService.findById(user_id).get().getPasswordHashed();
        user.setPasswordHashed(password);
        user.setId(user_id);
        userService.save(user);
        return "redirect:/profile_user/" + user_id;
    }
}
