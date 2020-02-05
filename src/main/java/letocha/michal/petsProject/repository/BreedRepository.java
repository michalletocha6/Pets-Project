package letocha.michal.petsProject.repository;

import letocha.michal.petsProject.entity.Breed;
import letocha.michal.petsProject.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Integer> {

    List<Breed> findAllBreedsByType(Type type);
}
