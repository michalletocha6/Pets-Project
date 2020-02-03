package letocha.michal.petsProject.service;

import letocha.michal.petsProject.entity.User;
import letocha.michal.petsProject.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    Methods with database

    public void addUser(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void updateUserEditData(User user) {
        User userToUpdate = userRepository.findById(user.getId()).get();
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setDescription(user.getDescription());
        userToUpdate.setEmail(user.getEmail());
        userRepository.save(userToUpdate);
    }

    public void updateUserPasswordEditData(User user, User userFromSession) {
        User userToUpdate = userRepository.findById(userFromSession.getId()).get();
        userToUpdate.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(userToUpdate);
    }

//    Session methods

    public void addUserToSession(HttpServletRequest request, User user) {
        request.getSession().setAttribute("userSession", user);
    }


    public User getUserFromSession(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("userSession");
    }
}