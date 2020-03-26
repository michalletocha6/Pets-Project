package letocha.michal.petsProject.service;

import letocha.michal.petsProject.entity.Advertisement;
import letocha.michal.petsProject.repository.AdvertisementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {
    private final AdvertisementRepository advertisementRepository;
    private final UserService userService;

    public AdvertisementService(AdvertisementRepository advertisementRepository, UserService userService) {
        this.advertisementRepository = advertisementRepository;
        this.userService = userService;
    }

    public List<Advertisement> getCurrentUserAdvertisements() {
        return advertisementRepository.findAllByUserId(userService.getUserFromContext().getId());
    }

    public void saveAdvertisementToDataBase(Advertisement advertisement) {
        advertisement.setUser(userService.getUserFromContext());
        advertisementRepository.save(advertisement);
    }
}
