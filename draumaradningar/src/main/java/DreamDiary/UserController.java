package DreamDiary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import javax.validation.Valid;

@Controller
public class UserController{
	

@Controller
public class LoginController extends WebMvcConfigurerAdapter {
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("passwordConfirm");
	}
	private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public LoginController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
	}
	/*
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }
	*/
	
	//For displaying the login page
    @GetMapping("/login")
    public String userInfoForm(Model model) {
		model.addAttribute("user", new User());
        return "login";
    }
	
	//For receiveing data from loginform POSTed to /login
	@PostMapping("/login")
    public String userInfoSubmit(@Valid User userinfo, BindingResult bindingResult, Model model, Errors errors) {
		userinfo.setPasswordConfirm(userinfo.getPassword());
		if (bindingResult.hasErrors()) {
            System.out.println(errors.toString());
			return "login";
        }

		//validate user here?
		//databaseController.getUser(userinfo.name, userinfo.password)
		model.addAttribute("user", userinfo);
        return "result";	
    }
	/*
	
	//For when connecting to facebook
	@GetMapping("/login")
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "login";
        }

        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        return "result";
    }
	*/
}

@Controller
public class newUserController{
	
	//For creating a new user
	@PostMapping("/newUser")
	public String RequestNewUser(@Valid User userinfo, BindingResult bindingResult, Model model, Errors errors){
		if (bindingResult.hasErrors()) {
            return "newUser";
        }
		else if (!userinfo.getPassword().equals(userinfo.getPasswordConfirm())){
			errors.rejectValue("passwordConfirm", "","Your passwords don't match");
			return "newUser";
		}
		//DatabaseController.addUser(userinfo);
		model.addAttribute("user", userinfo);
		return "result";
	}
	
	//for displaying the form for registering a new user
	@GetMapping("/newUser")
	public String newUserForm(Model model){
		model.addAttribute("user", new User());
		return "newUser";
	}

}
}