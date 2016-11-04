package DreamDiary;
import java.util.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {

  @NotNull
  @Size(min=2, max=30)
  private String name;
    
  @NotNull
  @Size(min=8, max=30)
  private String password;
  
  private int id;
  protected List<Dream> dreamList = new ArrayList<Dream>();

  // Constructor
  //Needed for init
  public User(){}
  
  public User(int userId, String userName, String userPassword) {
    this.name = userName;
    this.id = userId;
    this.password = userPassword;
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

  public String toString(){
    return "" + id + " " + name + " " + password;
  }

}
