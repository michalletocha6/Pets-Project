package letocha.michal.petsProject.repository;

import letocha.michal.petsProject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByName(String name);
//    List<Animal> findAnimalsByUser
}
