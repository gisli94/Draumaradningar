package DreamDiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        
		SpringApplication.run(Application.class, args);
        //DatabaseController db = new DatabaseController();
        //Dream dream = new Dream("Navn", 9, "Mig dreymdi kött.", 1);
        //Interpretation.interpret(dream);
        //db.addDream(dream);
        //Dream[] dreams = db.testQuery();
        //System.out.println(dreams[0]);
    }

}
