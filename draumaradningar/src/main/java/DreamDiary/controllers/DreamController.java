package DreamDiary.controllers;
import DreamDiary.entities.*;

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
        model.addAttribute("user", new User());
        //model.addAttribute("interpretation", new Interpretation ());
        return "dream";
    }

    @PostMapping("/dream")
    public String dreamSubmit(@ModelAttribute Dream dream, @ModelAttribute User user, Model model) {
    	//dream.setDate(dream.getDate());
    	//dream.setAnswer(new StringBuilder(dream.getContent()).reverse().toString());
    	//interpretation.setDream(dream);
        //Interpretation.interpret(dream);
		model.addAttribute("dream", dream);
        model.addAttribute("user", user);
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

    @GetMapping("/diary")
    public String diaryList(Model model) {
        
        DatabaseController db = new DatabaseController();
        Dream[] temp = db.getDreams(9);
        Dream[] dreams = new Dream[10];
        int l = temp.length;
        for (int i = 0; i < l; i++){
            dreams[i] = temp[i];
        }
        for (int i = l; i < 10; i++){
            dreams[i] = new Dream();
        }
        //Dream dream = dreams[0];
        model.addAttribute("dreams", dreams);
        
        //System.out.println(dream);
        
        //model.addAttribute("dream", new Dream());
        return "diary";
    }
}
