package DreamDiary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.Errors;
import org.springframework.validation.BindingResult;

@Controller
public class DreamController {

    @GetMapping("/dream")
    public String dreamForm(Model model) {
        model.addAttribute("dream", new Dream());
        //model.addAttribute("interpretation", new Interpretation ());
        return "dream";
    }

    @PostMapping("/dream")
    public String dreamSubmit(@ModelAttribute Dream dream, Model model) {
    	//dream.setDate(dream.getDate());
    	//dream.setAnswer(new StringBuilder(dream.getContent()).reverse().toString());
    	//interpretation.setDream(dream);
        //Interpretation.interpret(dream);
		model.addAttribute("dream", dream);
        return "dream";
    }
   
   @GetMapping("/guestDream")
    public String guestDreamForm(Model model) {
        model.addAttribute("dream", new Dream());
        //model.addAttribute("interpretation", new Interpretation ());
        return "guestDream";
    }

    @PostMapping("/guestDream")
    public String gusetDreamSubmit(@ModelAttribute Dream dream, Model model) {
    	//dream.setDate(dream.getDate());
    	//dream.setAnswer(new StringBuilder(dream.getContent()).reverse().toString());
    	//interpretation.setDream(dream);
        //Interpretation.interpret(dream);
		model.addAttribute("dream", dream);
        return "guestDream";
    }
}
