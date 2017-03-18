package DreamDiary.controllers;
import DreamDiary.services.UserService;
import DreamDiary.entities.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/mobuser")
public class MobileController{
	
	UserService userService = new UserService();
	
	//not sure if needed
/*	@RequestMapping("/mobguestuser")
	public User MobileGuestUser() {
        return new User();
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public User MobileGuestUser(@RequestParam(value="name", defaultValue="World") @PathVariable String name) {
        return new User();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User MobileGuestUser(@RequestBody User userinfo) {
		//validate user
		User user = userService.loginUser(userinfo);
		if(user == null){
			//errors.rejectValue("name", "","Wrong user name or password");
			return new User();
		}
		else{
			return user;
		}
	}
}