package DreamDiary;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;

@Controller
@RequestMapping("/login")
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
	
	//For receiveing data from loginform
	@PostMapping
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
	//For connecting to facebook
	@GetMapping
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
	//For displaying the form
    @GetMapping
    public String userInfoForm(User userinfo) {
        return "login";
    }
	/*
	@PostMapping("/newUser")
	public String RequestNewUser(@Valid User userinfo, BindingResult bindingResult, Model model){
		
		
		return "welcome";
	}
	
	@GetMapping("newUser")
	public String newUserForm(User userinfo)
*/
}
