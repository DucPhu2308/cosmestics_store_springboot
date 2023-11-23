package hcmute.springbootdemo.Controller.User;

import hcmute.springbootdemo.Entity.Review;
import hcmute.springbootdemo.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="review")
public class ReviewUserController {

    @Autowired
    ReviewRepository reviewRepository;

    @PostMapping(value="/review1")
    public String contact(@ModelAttribute("contact") Review review,
                          ModelMap modelMap, @PathVariable(value = "id") int id ){
        reviewRepository.save(review);
        return "user/contact";
    }

}
