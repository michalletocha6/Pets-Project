package letocha.michal.petsProject.service;

import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.entity.CurrentUser;
import letocha.michal.petsProject.entity.Role;
import letocha.michal.petsProject.repository.RoleRepository;
import letocha.michal.petsProject.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

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

    public AppUser getUserFromContext() {
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return currentUser.getAppUser();
    }

//    Methods with database

    public void addUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        Role userRole = roleRepository.findRoleByName("ROLE_USER");
        appUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(appUser);
    }

    public AppUser getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public AppUser getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void updateUserEditData(AppUser appUser) {
        AppUser appUserToUpdate = userRepository.findUserByEmail(getUserFromContext().getEmail());

        appUserToUpdate.setEmail(appUser.getEmail());
        appUserToUpdate.setUsername(appUser.getUsername());
        appUserToUpdate.setDescription(appUser.getDescription());
        userRepository.save(appUserToUpdate);

        getUserFromContext().setUsername(appUser.getUsername());
        getUserFromContext().setEmail(appUser.getEmail());
    }

    public void updateUserPhoto(AppUser appUser) {
        AppUser appUserToUpdate = userRepository.findUserByEmail(getUserFromContext().getEmail());

        appUserToUpdate.setPhoto(appUser.getPhoto());
        userRepository.save(appUserToUpdate);
    }

    public void updateUserPasswordEditData(AppUser appUser) {
        AppUser appUserToUpdate = userRepository.findUserByEmail(getUserFromContext().getEmail());
        appUserToUpdate.setPassword(passwordEncoder.encode(appUser.getPassword()));
        userRepository.save(appUserToUpdate);
    }

//    public List<Animal> findAnimalsByUser(User user) {
//        return userRepository.find
//    }

}