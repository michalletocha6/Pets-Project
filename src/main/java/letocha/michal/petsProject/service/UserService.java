package letocha.michal.petsProject.service;

import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.entity.Role;
import letocha.michal.petsProject.repository.RoleRepository;
import letocha.michal.petsProject.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    Methods with database

    public void addUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        Role userRole = roleRepository.findRoleByName("ROLE_USER");
        appUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(appUser);
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public AppUser getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public AppUser getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void updateUserEditData(AppUser appUser) {
        AppUser appUserToUpdate = userRepository.findById(appUser.getId()).get();
        appUserToUpdate.setUsername(appUser.getUsername());
        appUserToUpdate.setDescription(appUser.getDescription());
        appUserToUpdate.setEmail(appUser.getEmail());
        userRepository.save(appUserToUpdate);
    }

    public void updateUserPasswordEditData(AppUser appUser, AppUser appUserFromSession) {
        AppUser appUserToUpdate = userRepository.findById(appUserFromSession.getId()).get();
        appUserToUpdate.setPassword(BCrypt.hashpw(appUser.getPassword(), BCrypt.gensalt()));
        userRepository.save(appUserToUpdate);
    }

//    public List<Animal> findAnimalsByUser(User user) {
//        return userRepository.find
//    }

//    Session methods

    public void addUserToSession(HttpServletRequest request, AppUser appUser) {
        request.getSession().setAttribute("userSession", appUser);
    }


    public AppUser getUserFromSession(HttpServletRequest request) {
        return (AppUser) request.getSession().getAttribute("userSession");
    }
}