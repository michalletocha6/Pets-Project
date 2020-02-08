package letocha.michal.petsProject.service;

import letocha.michal.petsProject.entity.Animal;
import letocha.michal.petsProject.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final UserService userService;

    public AnimalService(AnimalRepository animalRepository, UserService userService) {
        this.animalRepository = animalRepository;
        this.userService = userService;
    }

    public void addAnimalToDatabase(Animal animal) {
        animal.setUser(userService.getUserFromContext());
        animalRepository.save(animal);
    }


    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }
}