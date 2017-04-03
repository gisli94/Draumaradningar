package DreamDiary.controllers;
import DreamDiary.services.*;
import DreamDiary.entities.*;

import java.util.*;
import java.time.*;
//import org.springframework.util.support.Base64;
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
	DreamService dreamService;
	
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
		User user = userService.loginUser(userinfo);
		System.out.println(user);
		if(user == null){
			return null;
		}
		else{
			user.setPassword("");
			return user;
		}
	}
	
	
	@RequestMapping(value = "/dreams", method = RequestMethod.GET)
	public List<Dream> MobileFetchDreams(@RequestParam int userId){
		dreamService = new DreamService();
		return this.dreamService.fetchUserIdDreams(userId);
	}
	
		
	@RequestMapping(value = "/mobdream", method = RequestMethod.GET)
	public Dream MobileReceiveDream(@RequestParam int userId, 
											@RequestParam String title,
											@RequestParam String content,
											@RequestParam String year,
											@RequestParam String month,
											@RequestParam String day											
											){
		Dream dream = new Dream();
		dream.setName(title);
		dream.setContent(content);
		
		dream.setDate(LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day)));
		User user = new User();
		user.setId(userId);
				
		this.dreamService = new DreamService(dream);
		return this.dreamService.linkUser(user);
	}
	
	
	
	@RequestMapping(value = "/mobdream", method = RequestMethod.POST)
	public Dream MobileTakeDream(@RequestBody Dream dream) {
		System.out.println("... Incoming dream ... ");
		
		User user = new User();
		user.setId(dream.getUserId());
		this.dreamService = new DreamService(dream);
		return this.dreamService.linkUser(user);
	}
	
	
	@RequestMapping(value = "/mobsignup", method = RequestMethod.GET)
 	public User MobileSignUp(@RequestParam String name, @RequestParam String pass){
 		User user = new User();
 		user.setName(name);
		//user.setName(stringDecrypt(pass));
 		user.setPassword(pass);
 		System.out.println("User: " + user.toString());
 		if (userService.createUser(user)) {
 			user.setPassword(pass);
 			User u = userService.loginUser(user);
 			return u;
 		}
 		return new User();
 	}
	
	
/*	protected String stringDecrypt(String secret) {
		byte[] valueDecoded= Base64.decode(secret.getBytes(), 0);
		String pass = new String(valueDecoded);
		pass = pass.substring(0,(pass.length() - 13));
		String reverse = new StringBuilder(pass).reverse().toString();
		byte[] valueDecoded2= Base64.decode(reverse.getBytes(), 0);
		return new String(valueDecoded2);
    }*/
}