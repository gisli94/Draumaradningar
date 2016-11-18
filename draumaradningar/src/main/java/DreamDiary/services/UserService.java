package DreamDiary.services;
import DreamDiary.entities.*;
import DreamDiary.controllers.*;


//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{

	DatabaseController datab;
	//BCryptPasswordEncoder passencode;
	
	public UserService(){
		this.datab = new DatabaseController();
		//this.passencode = new BCryptPasswordEncoder();
	}
	
	//returns true if the user is successfully added to database.
	public boolean createUser(User user){
		//String password = passencode.encode(user.getPassword());
		//user.setPassword(password);
		return datab.addUser(user);
	}
	
	//connect all info on user and log him in
	public User loginUser(User user){
		//String password = passencode.encode(user.getPassword());
		User[] usrs = datab.getUsers(user.getName(), user.getPassword());
		if(usrs.length == 0){
			return null;
		}
		else{
			User usr = usrs[0];
			//Gather all info on user..
			//Dream[] dreams = db.getDreams(usr.getId());
			//usr.populateDreams(dreams)
			return usr;
		}	
		
	}

}