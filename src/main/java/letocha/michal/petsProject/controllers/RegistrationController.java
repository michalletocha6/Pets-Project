package letocha.michal.petsProject.controllers;

import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.service.UserService;
import letocha.michal.petsProject.validator.validationGroups.RegisterValidationGroupName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "user/register";
    }

    @PostMapping("/register")
    public String addUserToDB(@Validated(RegisterValidationGroupName.class) AppUser appUser, BindingResult result) {
        if (result.hasErrors()) {
            return "user/register";
        }
        userService.addUser(appUser);
        return "redirect:/login";
    }
}