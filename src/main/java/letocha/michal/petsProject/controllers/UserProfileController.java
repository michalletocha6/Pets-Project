package letocha.michal.petsProject.controllers;

import letocha.michal.petsProject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/profile")
public class UserProfileController {
    private final UserService userService;

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showProfile() {
        return "user/showProfile";
    }

    @GetMapping("/animals")
    public String showAllAnimals() {
        return "animal/showAllAnimals";
    }

    @GetMapping("/edit")
    public String editUserData(Model model, HttpServletRequest request) {
        model.addAttribute("user", userService.getUserFromSession(request));
        return "user/editUserData";
    }

    @PostMapping("/edit")
    public String editUserDataInDatabase() {
        return "redirect:/profile";
    }
}
