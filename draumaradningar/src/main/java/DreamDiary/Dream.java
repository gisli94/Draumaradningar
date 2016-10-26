package DreamDiary;

import java.util.*;
import java.time.LocalDate;

public class Dream {

    private String name; //vantar getset
    private int userId;
    private String content;
    private int id;
    private LocalDate date;
    private Interpretation interpretation;

    public Dream(String name, int userId, String content, int id) {
        this.name = name;
        this.userId = userId;
        this.content = content;
        this.id = id;
        this.date = LocalDate.now();
        this.interpretation = new Interpretation();
    }

    public Dream(int id, int userId, LocalDate date, String name, String content, Interpretation interpretation){
        this.name = name;
        this.userId = userId;
        this.content = content;
        this.id = id;
        this.date = date;
        this.interpretation = interpretation;
    }

    public Dream(){}


    // Notkun: inputDream.interpret()
    // Fyrir: inputDream er hlutur af tagi Dream.
    // Eftir: inputDream hefur fengid Interpretation attribute
    /*
    protected void interpret() {
      this.interpretation = (new StringBuilder(this.content).reverse().toString());
    }
    */

    // Notkun: editDream(old_dream)
    // Fyrir: old_dream er hlutur af tagi Dream
    // Eftir:
    // Liklega redundant. Notum bara setContent
    //protected void editDream(Dream old_dream) {}


    // Only getters and setters bellow this point
    public String getName(){
        return name;
    }

    public void setName(String new_name){
        this.name = new_name;
    }

    public int getUserId(){
      return userId;
    }

    public void setUserId(int new_userId){
      this.userId = new_userId;
    }

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

    public LocalDate getDate() {
      return date;
    }

    public void setDate(LocalDate new_date){
        this.date = new_date;
    }

    public Interpretation getInterpretation(){
        return interpretation;
    }

    public void setInterpretation(Interpretation new_interpretation){
        this.interpretation = new_interpretation;
    }

    public String toString(){
        return ("" + name + " " + userId + " " + content + " " + id + " " + date + " " + interpretation.getContent());
    }
}
