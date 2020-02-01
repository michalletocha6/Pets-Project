package letocha.michal.pets_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
    @GetMapping("/register")
    public String registration() {

        return "user/signup";
    }
}
