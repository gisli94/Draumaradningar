package DreamDiary.controllers;
import DreamDiary.services.*;
import DreamDiary.entities.*;

import java.util.*;
import java.time.*;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MobileController{
	
	UserService userService = new UserService();
	DreamService dreamService;
	
	
	@RequestMapping(value = "/mobuser", method = RequestMethod.GET)
	public User MobileGuestUser(@RequestParam String name, @RequestParam String pass) {
        System.out.println("GET call");
		User us = new User();
		us.setName(name);
		us.setPassword(stringDecrypt(pass));
		User user = userService.loginUser(us);

		if(user == null){
			return null;
		}
		else{
			user.setPassword("");
			return user;
		}
		
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
		Dream dr = this.dreamService.linkUser(user);
		System.out.println(dr);
		return dr;
	}
	
	
	
	@RequestMapping(value = "/mobsignup", method = RequestMethod.GET)
 	public User MobileSignUp(@RequestParam String name, @RequestParam String pass){
 		User user = new User();
 		user.setName(name);
		String word = stringDecrypt(pass);
		user.setPassword(word);

 		if (userService.createUser(user)) {
 			user.setPassword(word);
 			User u = userService.loginUser(user);
			u.setPassword("");
 			return u;
 		}
 		return new User();
 	}
	
	
	protected String stringDecrypt(String secret) {
		byte[] valueDecoded= Base64Utils.decode(secret.getBytes());
		String pass = new String(valueDecoded);
		pass = pass.substring(0,(pass.length() - 13));
		String reverse = new StringBuilder(pass).reverse().toString();
		byte[] valueDecoded2= Base64Utils.decode(reverse.getBytes());
		return new String(valueDecoded2);
    }
}