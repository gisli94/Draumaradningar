package DreamDiary.services;
import DreamDiary.entities.*;
import DreamDiary.controllers.*;


public class DreamService{

	DatabaseController database;
	InterpreterService interp;
	Dream dream;
	
	//Smiður
	public DreamService(){
		this.database = new DatabaseController();
		this.interp = new InterpreterService();
		this.dream = null;
	}
	
	//Smiður sem tekur inn draum
	public DreamService(Dream dream){
		this.database = new DatabaseController();
		this.interp = new InterpreterService();
		this.dream = dream;
	}
	
	//Túlkar, tengir við notanda user og sendir inn í gagnagrunn
	public Dream linkUser(User user){
		this.dream.setUserId(user.getId());		
		this.dream.setInterpretation(this.interp.analyzeDream(this.dream.getContent()));
		if(logDream()){
			return this.dream;
		}
		else{
			return null;
		}
		
	}
	//Túlkar án þess að tengja við notanda
	public Dream guestDream(){
		this.dream.setInterpretation(this.interp.analyzeDream(this.dream.getContent()));
		return this.dream;
		
	}
	
	private boolean logDream(){
		return database.addDream(this.dream);		
	}
	
}