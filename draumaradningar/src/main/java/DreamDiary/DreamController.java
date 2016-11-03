package DreamDiary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DreamController {

    @GetMapping("/dream")
    public String dreamForm(Model model) {
        model.addAttribute("dream", new Dream("", 1, "", 1));
        //model.addAttribute("interpretation", new Interpretation ());
        return "dream";
    }

    @PostMapping("/dream")
    public String dreamSubmit(@ModelAttribute Dream dream) {
    	//dream.setDate(dream.getDate());
    	//dream.setAnswer(new StringBuilder(dream.getContent()).reverse().toString());
    	//interpretation.setDream(dream);
        Interpretation.interpret(dream);
        return "dream";
    }

}
