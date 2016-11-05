package DreamDiary;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.Errors;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import javax.validation.Valid;

@Controller
public class UserController{
	

	@Controller
	public class LoginController extends WebMvcConfigurerAdapter {

		private Facebook facebook;
		private ConnectionRepository connectionRepository;

		public LoginController(Facebook facebook, ConnectionRepository connectionRepository) {
			this.facebook = facebook;
			this.connectionRepository = connectionRepository;
		}

		//For displaying the login page
		@GetMapping("/login")
		public String userInfoForm(Model model) {
			model.addAttribute("user", new User());
			return "login";
		}
		
		//For receiveing data from loginform POSTed to /login
		@PostMapping("/login")
		public String userInfoSubmit(@Valid User userinfo, final RedirectAttributes redirectAttributes, BindingResult bindingResult, Model model, Errors errors) {
			if (bindingResult.hasErrors()) {
				return "login";
			}
			
			//validate user here?
			//databaseController.getUser(userinfo.name, userinfo.password)
			//model.addAttribute("user", userinfo);
			redirectAttributes.addFlashAttribute("user", userinfo);
			return "redirect:/dream";
			
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
		public String RequestNewUser(@Valid User userinfo,final RedirectAttributes redirectAttributes, BindingResult bindingResult, Model model, Errors errors){
			if (bindingResult.hasErrors()) {
				return "newUser";
			}
			else if (!userinfo.getPassword().equals(userinfo.getPasswordConfirm())){
				errors.rejectValue("passwordConfirm", "","Your passwords don't match");
				return "newUser";
			}
			//DatabaseController.addUser(userinfo);
			//til ad koma gognum milli controllera
			redirectAttributes.addFlashAttribute("user", userinfo);
			return "redirect:/dream";
		}
		
		//for displaying the form for registering a new user
		@GetMapping("/newUser")
		public String newUserForm(Model model){
			model.addAttribute("user", new User());
			return "newUser";
		}

	}
}