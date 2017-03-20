package DreamDiary.controllers;
import DreamDiary.services.*;
import DreamDiary.entities.*;

import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
//@RequestMapping("/mobuser")
public class MobileController{
	
	UserService userService = new UserService();
	DreamService dreamService = new DreamService();
	
	//not sure if needed
/*	@RequestMapping("/mobguestuser")
	public User MobileGuestUser() {
        return new User();
	}*/
	
	@RequestMapping(value = "/mobuser", method = RequestMethod.GET)
	public User MobileGuestUser(@RequestParam String name, @RequestParam String pass) {
        System.out.println("GET call");
		User us = new User();
		us.setName(name);
		us.setPassword(pass);
		User user = userService.loginUser(us);
		System.out.println(user);
		if(user == null){
			//errors.rejectValue("name", "","Wrong user name or password");
			return null;
		}
		else{
			user.setPassword("");
			//user.setDreams(null);
			return user;
		}
		
	}
	
	@RequestMapping(value = "/mobuser", method = RequestMethod.POST)
	public User MobileUser(@RequestBody User userinfo) {
		//validate user
		
		System.out.println("Got Called");
		//return "got called";
		User user = userService.loginUser(userinfo);
		System.out.println(user);
		if(user == null){
			//errors.rejectValue("name", "","Wrong user name or password");
			return null;
		}
		else{
			user.setPassword("");
			//user.setDreams(null);
			return user;
		}
	}
	
	
	@RequestMapping(value = "/dreams", method = RequestMethod.GET)
	public List<Dream> MobileFetchDreams(@RequestParam int userId){
		return this.dreamService.fetchUserIdDreams(userId);
	}
	
}