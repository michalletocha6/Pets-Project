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

    //SESSION ANIMAL--------------------------------------------------
    public void addAnimalToSession(HttpServletRequest request, Animal animal) {
        HttpSession session = request.getSession();
        session.setAttribute("currentAnimalEdit", animal);
    }

    public Animal getAnimalFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Animal) session.getAttribute("currentAnimalEdit");
    }
}