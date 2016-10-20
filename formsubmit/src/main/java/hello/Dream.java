package hello;

public class Dream {

    private String date;
    private String content;
    private String answer;

    /*
    public Dream(String date, String content, String answer) {
        this.date = date;
        this.content = content;
        this.answer = answer;
    }
    */

    public Dream(String date, String content) {
        this.date = date;
        this.content = content;
    }

    public Dream(){};

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /*
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    */

}