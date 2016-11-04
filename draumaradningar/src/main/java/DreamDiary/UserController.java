package DreamDiary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Controller
public class UserController extends WebMvcConfigurerAdapter {
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }
	
	//For receiveing data from form
	@PostMapping("/login")
    public String userInfoSubmit(@Valid User userinfo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

		//validate user here?
		//databaseController.getUser(userinfo.name, userinfo.password)
		model.addAttribute("user", userinfo);
        return "result";
    }
	
	//For displaying the form
    @GetMapping("/login")
    public String userInfoForm(User userinfo, Model model) {
        return "login";
    }
	/*
	@PostMapping("/newUser")
	public String RequestNewUser(@Valid User userinfo, BindingResult bindingResult){
		
		
		return "welcome";
	}
*/
}
