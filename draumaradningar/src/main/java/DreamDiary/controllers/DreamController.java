package DreamDiary.controllers;
import DreamDiary.entities.*;
import DreamDiary.services.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.validation.Errors;
//import org.springframework.validation.BindingResult;

@SessionAttributes("user")
@Controller
public class DreamController {
	private DreamService dreamService;
	private UserService userService;
	
	
    @GetMapping("/dream")
    public String dreamForm(@ModelAttribute User user, Model model) {
        model.addAttribute("dream", new Dream());
		model.addAttribute("user", user);
		model.addAttribute("dreams", user.getDreams());
		System.out.println("Hallo");
        return "dream";
    }

    @PostMapping("/dream")
    public String dreamSubmit(@ModelAttribute Dream dream, @ModelAttribute User user, Model model) {
		userService = new UserService(user); 
		model.addAttribute("user", userService.linkDream(dream));
		model.addAttribute("dreams", user.getDreams());
		System.out.println(dream);
		return "dream";
    }
   
    @GetMapping("/guestDream")
    public String guestDreamForm(Model model) {
        model.addAttribute("dream", new Dream());
        return "guestDream";
    }

    @PostMapping("/guestDream")
    public String guestDreamSubmit(@ModelAttribute Dream dream, Model model) {
		this.dreamService = new DreamService(dream);
		model.addAttribute("dream", this.dreamService.guestDream());
        return "guestDream";
    }

	@PostMapping("/logout")
	public String logoff(SessionStatus status){
		status.setComplete();
		return "login";
		
	}
}
