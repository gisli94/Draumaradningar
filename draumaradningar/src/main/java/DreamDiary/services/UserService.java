package DreamDiary.services;
import DreamDiary.entities.*;
import DreamDiary.controllers.*;

import java.util.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService{

	DatabaseController datab;
	DreamService dreamService;
	User user;
	BCryptPasswordEncoder passencode;
	
	public UserService(){
		this.datab = new DatabaseController();
		this.user = null;
		this.passencode = new BCryptPasswordEncoder();
	}
	public UserService(User user){
		this.datab = new DatabaseController();
		this.user = user;

	}
	
	public User linkDream(Dream dream){
			this.dreamService = new DreamService(dream);
			this.dreamService.linkUser(this.user);
			this.user.addDream(dream);
			return this.user;
		
	}
	//returns true if the user is successfully added to database.
	public boolean createUser(User user){
		String password = passencode.encode(user.getPassword());
		user.setPassword(password);
		return datab.addUser(user);
	}
	
	//connect all info on user and log him in
	public User loginUser(User user){
		User[] usrs = datab.getNamedUsers(user.getName());
		if(usrs.length == 0){
			return null;
		}
		else{
			for(int i = 0; i<usrs.length; i++){
				User usr = usrs[i];
				if (BCrypt.checkpw(user.getPassword(), usr.getPassword())){
						//Gather all info on user..
						List<Dream> dreams = datab.getDreams(usr.getId());
						usr.setDreams(dreams);
						return usr;
				}
			}
			return null;

		}	
		
	}

}