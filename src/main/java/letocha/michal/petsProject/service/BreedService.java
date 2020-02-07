package letocha.michal.petsProject.service;

import letocha.michal.petsProject.entity.Breed;
import letocha.michal.petsProject.repository.BreedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedService {
    private final BreedRepository breedRepository;

    public BreedService(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    public List<Breed> getAllBreedsForTypeId(Integer id) {
        return breedRepository.findAllBreedsByTypeId(id);
    }

    public List<Breed> findAll() {
        return breedRepository.findAll();
    }
}
