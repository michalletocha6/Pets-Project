package letocha.michal.petsProject.controllers;

import letocha.michal.petsProject.entity.Advertisement;
import letocha.michal.petsProject.service.AdvertisementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/advertisement")
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("/add")
    public String addAdvertisementForm(Model model) {
        model.addAttribute("advertisement", new Advertisement());
        return "advertisement/advertisementAddForm";
    }

    @PostMapping("/add")
    public String addAdvertisementToDB(@Valid Advertisement advertisement, BindingResult result) {
        if (result.hasErrors()) {
            return "advertisement/advertisementAddForm";
        }
        advertisementService.saveAdvertisementToDataBase(advertisement);
        return "redirect:/profile/advertisements";
    }
}
