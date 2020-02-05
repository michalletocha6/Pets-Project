package letocha.michal.petsProject.controllers;

import letocha.michal.petsProject.entity.Animal;
import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.entity.CurrentUser;
import letocha.michal.petsProject.service.UserService;
import letocha.michal.petsProject.validator.validationGroups.EditPasswordValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.EditPhotoValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.EditValidationGroupName;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

    @GetMapping("/edit")
    public String editUserData(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("appUser", userService.getUserByEmail(customUser.getAppUser().getEmail()));
        model.addAttribute("appUserPhoto", new AppUser());
        model.addAttribute("appUserPassword", new AppUser());
        return "user/editUserData";
    }

    @PostMapping("/edit/changeUserData")
    public String editUserDataInDatabase(Model model, @Validated({EditValidationGroupName.class}) AppUser appUser,
                                         BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("appUserPhoto", new AppUser());
            model.addAttribute("appUserPassword", new AppUser());
            return "user/editUserData";
        }
        userService.updateUserEditData(appUser);
        return "redirect:/profile";
    }

    @PostMapping("/edit/changePhoto")
    public String editUserPhotoInDatabase(@AuthenticationPrincipal CurrentUser customUser, Model model,
                                          @ModelAttribute(value = "appUserPhoto")
                                          @Validated({EditPhotoValidationGroupName.class}) AppUser appUser,
                                          BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("appUserPassword", new AppUser());
            model.addAttribute("appUser", userService.getUserByEmail(customUser.getAppUser().getEmail()));
            return "user/editUserData";
        }
        userService.updateUserPhoto(appUser);
        return "redirect:/profile";
    }

    @PostMapping("/edit/changePassword")
    public String editUserPasswordInDatabase(@AuthenticationPrincipal CurrentUser customUser, Model model,
                                             @ModelAttribute(value = "appUserPassword")
                                             @Validated({EditPasswordValidationGroupName.class}) AppUser appUser,
                                             BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("appUserPhoto", new AppUser());
            model.addAttribute("appUser", userService.getUserByEmail(customUser.getAppUser().getEmail()));
            return "user/editUserData";
        }
        userService.updateUserPasswordEditData(appUser);
        return "redirect:/profile";
    }

    @GetMapping("/animal/add")
    public String addAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal/addAnimal";
    }
}