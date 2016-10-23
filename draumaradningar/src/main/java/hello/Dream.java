package DreamDiary;
import java.util.*;
public class Dream {

    private String content;
    private int id;
    private Date dreamDate;
    //private Interpretation interpretation;
    private String interpretation;
    private int userId;

    public Dream(int dreamId, int userId, String content) {
        this.id = dreamId;
        this.userId = userId;
        this.content = content;
        this.dreamDate = new java.util.Date();
    }

    public void test(){
      System.out.print("Draumur virkar");
    }

    // Notkun: inputDream.interpret()
    // Fyrir: inputDream er hlutur af tagi Dream.
    // Eftir: inputDream hefur fengid Interpretation attribute
    protected void interpret() {
      this.interpretation = (new StringBuilder(this.content).reverse().toString());
    }

    // Notkun: editDream(old_dream)
    // Fyrir: old_dream er hlutur af tagi Dream
    // Eftir:
    // Liklega redundant. Notum bara setContent
    //protected void editDream(Dream old_dream) {}


    // Only getters and setters bellow this point
    public String getContent(){
      return content;
    }

    public void setContent(String dreamText){
      this.content=dreamText;
    }

    public int getId() {
      return id;
    }

    public void setId(int new_dreamId){
      this.id = new_dreamId;
    }

    public int getUserId(){
      return userId;
    }

    public void setUserId(int new_userId){
      this.userId = new_userId;
    }

    public Date getDate() {
      return dreamDate;
    }
}
