package letocha.michal.petsProject.controllers;

import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.entity.CurrentUser;
import letocha.michal.petsProject.service.UserService;
import letocha.michal.petsProject.validator.validationGroups.EditPasswordValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.EditValidationGroupName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/profile")
public class UserProfileController {
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showProfile(Model model, HttpServletRequest request) {
//        model.addAttribute("user", userService.getUserFromSession(request));
        return "user/showProfile";
    }

//    @ModelAttribute("animals")
//    public List<Animal> listOfUserAnimals(HttpServletRequest request) {
//
//    }

    @GetMapping("/animals")
    public String showAllAnimals() {
        return "animal/showAllAnimals";
    }

    @GetMapping("/edit")
    public String editUserData(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("appUser", userService.getUserByEmail(customUser.getAppUser().getEmail()));
//        model.addAttribute("appUser1", userService.getUserByEmail(customUser.getAppUser().getEmail()));
        return "user/editUserData";
    }

    @PostMapping("/edit")
    public String editUserDataInDatabase(@Validated({EditValidationGroupName.class}) AppUser appUser,
                                         BindingResult result) {
        if (result.hasErrors()) {
            return "user/editUserData";
        }
        userService.updateUserEditData(appUser);
        return "redirect:/profile";
    }

    @GetMapping("/editPassword")
    public String editUserPassword(Model model) {
        model.addAttribute("user", new AppUser());
        return "user/editUserPassword";
    }

    @PostMapping("/editPassword")
    public String editUserPasswordInDatabase(@Validated(EditPasswordValidationGroupName.class) AppUser appUser,
                                             BindingResult result) {
        if (result.hasErrors()) {
            logger.info(String.valueOf(result.getErrorCount()));
            return "user/editUserPassword";
        }
//        userService.updateUserPasswordEditData(appUser, userService.getUserFromSession(request));
        return "redirect:/profile";
    }
}
