package DreamDiary.entities;
import java.util.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class User {

  @NotNull
  @Size(min=2, max=30)
  private String name;
    

  @Size(min=5, max=30)
  private String password;
  

  private String passwordConfirm;
  
  private int id;
  protected dreamList dreams;

  //Constructors
  public User(){
	  dreams = new dreamList();
  }
  
  public User(int userId, String userName, String userPassword) {
    this.name = userName;
    this.id = userId;
    this.password = userPassword;
	this.dreams = new dreamList();
  }

  // Notkun:
  // Fyrir:
  // Eftir:
  protected void deleteDream(List<Dream> my_dreams) {

  }

  // possibly redundant
  protected void updateUserInfo(String name, int id, String password){

  }


  // Only getters and setters bellow here:
  public String getName() {
    return name;
  }

  public void setName(String new_name) {
    this.name = new_name;
  }


  public int getId() {
    return id;
  }

  public void setId(int new_id) {
    this.id = new_id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String new_password) {
    this.password = new_password;
  }
  
  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String new_password) {
    this.passwordConfirm = new_password;
  }
  
  public void setDreams(List<Dream> dreams){
	  this.dreams.setDreams(dreams);
  }
  public void resetDreams(){
	  this.dreams = new dreamList();
  }
  
  public List<Dream> getDreams(){
	  return this.dreams.getDreams();
  }
  
  public void addDream(Dream dream){
	  this.dreams.addDream(dream);
	  
  }
  public String toString(){
    return "" + id + " " + name + " " + password;
  }

}
