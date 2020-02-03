package letocha.michal.petsProject.controllers;

import letocha.michal.petsProject.entity.User;
import letocha.michal.petsProject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "user/signup";
    }

    @PostMapping("/register")
    public String addUserToDB(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/signup";
        }
        userService.addUser(user);
        return "redirect:/";
    }
}