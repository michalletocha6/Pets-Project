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
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ModelAttribute("animals")
    public List<Animal> animalList() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/animal/add")
    public String addAnimalFirstPart(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal/addAnimal";
    }

    @GetMapping(value = "/animal/breed", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Breed> breedSendAjax(@RequestParam String typeId) {
        return breedService.getAllBreedsForTypeId(Integer.parseInt(typeId));
    }

    @PostMapping("/animal/add")
    public String saveAnimalToDataBase(@Validated({FirstPartAnimalAddFormGroupName.class}) Animal animal,
                                       BindingResult result) {
        if (result.hasErrors()) {
            return "animal/addAnimal";
        }
        animalService.addAnimalToDatabase(animal);
        return "redirect:/profile";
    }
}