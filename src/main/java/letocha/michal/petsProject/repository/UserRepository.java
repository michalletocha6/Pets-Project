package letocha.michal.petsProject.repository;

import letocha.michal.petsProject.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findUserByEmail(String email);
//    List<Animal> findAnimalsByUser
}