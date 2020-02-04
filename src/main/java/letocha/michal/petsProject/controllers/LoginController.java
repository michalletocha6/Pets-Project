package letocha.michal.petsProject.controllers;

import letocha.michal.petsProject.entity.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "user/login";
    }
}