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
public class UserController extends WebMvcConfigurerAdapter {
	

	
	private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public UserController(Facebook facebook, ConnectionRepository connectionRepository) {
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
    public String userInfoForm(User userinfo) {
        return "login";
    }
	
	//For receiveing data from loginform POSTed to /login
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
	
	//For validating password from signup form
	@Autowired
	@Qualifier("passwordValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	//For creating a new user
	@PostMapping("/newUser")
	public String RequestNewUser(@Valid User userinfo, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
            return "newUser";
        }
		//DatabaseController.addUser(userinfo);
		model.addAttribute("user", userinfo);
		return "dream";
	}
	
	//for displaying the form for registering a new user
	@GetMapping("/newUser")
	public String newUserForm(User userinfo){
		return "newUser";
	}

}
