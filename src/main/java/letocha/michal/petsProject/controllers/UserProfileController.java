package letocha.michal.petsProject.controllers;

import letocha.michal.petsProject.entity.Animal;
import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.entity.Breed;
import letocha.michal.petsProject.entity.CurrentUser;
import letocha.michal.petsProject.entity.Type;
import letocha.michal.petsProject.service.AnimalService;
import letocha.michal.petsProject.service.BreedService;
import letocha.michal.petsProject.service.TypeService;
import letocha.michal.petsProject.service.UserService;
import letocha.michal.petsProject.validator.validationGroups.EditPasswordValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.EditPhotoValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.EditValidationGroupName;
import letocha.michal.petsProject.validator.validationGroups.FirstPartAnimalAddFormGroupName;
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
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/profile")
public class UserProfileController {
    private final UserService userService;
    private final TypeService typeService;
    private final AnimalService animalService;
    private final BreedService breedService;

    public UserProfileController(UserService userService, TypeService typeService, AnimalService animalService, BreedService breedService) {
        this.userService = userService;
        this.typeService = typeService;
        this.animalService = animalService;
        this.breedService = breedService;
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
//  -----------------------------------------  ANIMAL SECTION ---------------------------------------- //

    @ModelAttribute("types")
    public List<Type> typeList() {
        return typeService.getAllTypes();
    }

    @GetMapping("/animal/add/1of2")
    public String addAnimalFirstPart(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal/addAnimalPartOne";
    }

    @PostMapping("/animal/add/1of2")
    public String saveFirstPartToSession(HttpServletRequest request,
                                          @Validated({FirstPartAnimalAddFormGroupName.class}) Animal animal,
                                          BindingResult result) {
        if (result.hasErrors()) {
            return "animal/addAnimalPartOne";
        }
        animalService.addAnimalToSession(request, animal);
        return "redirect:/profile/animal/add/2of2";
    }

    @GetMapping("/animal/add/2of2")
    public String addAnimalSecondPart(HttpServletRequest request, Model model) {
        if (animalService.getAnimalFromSession(request)!=null) {
            breedService.getAllBreedsForType(animalService.getAnimalFromSession(request).getType());
        }
//        model.addAttribute("breeds", )
        model.addAttribute("animal", new Animal());
        return "animal/addAnimalPartTwo";
    }

    @PostMapping("/animal/add/2of2")
    public String saveAnimalToDatabase(HttpServletRequest request,
                                          @Validated({FirstPartAnimalAddFormGroupName.class}) Animal animal,
                                          BindingResult result) {
        if (result.hasErrors()) {
            return "animal/addAnimalPartOne";
        }
        animalService.addAnimalToSession(request, animal);
        return "redirect:/profile/animal/add/2of2";
    }
}