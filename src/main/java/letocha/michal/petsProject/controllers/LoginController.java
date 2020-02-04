package letocha.michal.petsProject.controllers;

import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.service.UserService;
import letocha.michal.petsProject.validator.validationGroups.LoginValidationGroupName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "user/login";
    }

    @PostMapping("/login")
    public String loginValidation(@Validated({LoginValidationGroupName.class}) AppUser appUser, BindingResult result,
                                  HttpServletRequest request) {
        if (result.hasErrors()) {
            return "user/login";
        }
        userService.addUserToSession(request, userService.getUserByEmail(appUser.getEmail()));
        return "redirect:/";
    }
}