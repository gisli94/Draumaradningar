package DreamDiary.entities;
import java.util.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
//@Table(name = "user")
public class User {

  @NotNull
  @Size(min=2, max=30)
  private String name;
    
  //@NotNull
  @Size(min=5, max=30)
  private String password;
  
  //@NotNull
  //@Size(min=5, max=30)
  private String passwordConfirm;
  
  private int id;
  protected List<Dream> dreamList;

  //Constructors
  //Needed for init
  public User(){
	  dreamList = new ArrayList<Dream>();
  }
  
  public User(int userId, String userName, String userPassword) {
    this.name = userName;
    this.id = userId;
    this.password = userPassword;
	this.dreamList = new ArrayList<Dream>();
  }


  // Notkun: logDream(old_Dream_list, dream_text)
  // Fyrir: dream_text er texti draumsins, fenginn ur forum submission
  //        dream_text er a islensku(?)
  //
  // Eftir: Nytt Dream object hefur verid buid til og baett vid old_Dream_list
  //        nyja Dream objectid
  /*protected List<Dream> logDream(int dreamId, List<Dream> oldDreamList, String dream_text) {
    Dream nyr_draumur = new Dream(dreamId, dream_text);
    List<Dream> updatedDreamList = oldDreamList.add(nyr_draumur);
    return updatedDreamList;
  }*/

  // þarf að laga svo það noti nýja Dream constructorinn.
  /*
  protected Dream logDream(int dreamId, List<Dream> oldDreamList, String dream_text) {
    Dream nyr_draumur = new Dream(id, dreamId, dream_text);
    return nyr_draumur;
  }
  */


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

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	  this.dreamList = dreams;
  }
  public void resetDreams(){
	  this.dreamList = new ArrayList<Dream>();
  }
  
  public List<Dream> getDreams(){
	  return this.dreamList;
  }
  
  public void addDream(Dream dream){
	  this.dreamList.add(dream);
	  
  }
  public String toString(){
    return "" + id + " " + name + " " + password;
  }

}
