package letocha.michal.petsProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSecurityController {

    @GetMapping("/login1")
    public String login() {
        return "user/loginSecurity";
    }

    @GetMapping("/logout")
    public String logout() {
        return "user/loginSecurity";
    }
}