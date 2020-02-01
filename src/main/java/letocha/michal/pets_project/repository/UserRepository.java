package letocha.michal.pets_project.repository;

import letocha.michal.pets_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}