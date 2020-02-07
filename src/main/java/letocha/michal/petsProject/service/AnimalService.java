package letocha.michal.petsProject.service;

import letocha.michal.petsProject.entity.Animal;
import letocha.michal.petsProject.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void addAnimalToDatabase(Animal animal) {
        animalRepository.save(animal);
    }

}