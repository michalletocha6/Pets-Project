package letocha.michal.petsProject.controllers;

import letocha.michal.petsProject.entity.User;
import letocha.michal.petsProject.service.UserService;
import letocha.michal.petsProject.validator.LoginValidationGroupName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String loginValidation(@Validated({LoginValidationGroupName.class}) User user, BindingResult result,
                                  HttpServletRequest request) {
        if (result.hasErrors()) {
            return "user/login";
        }
        userService.addUserToSession(request, user);
        logger.info((String) request.getSession().getAttribute("user"));
        return "redirect:/";
    }
}