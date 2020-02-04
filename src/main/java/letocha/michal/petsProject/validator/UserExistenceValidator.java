package letocha.michal.petsProject.validator;

import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserExistenceValidator implements ConstraintValidator<UserExistence, AppUser> {
    private final UserService userService;

    public UserExistenceValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(AppUser appUser, ConstraintValidatorContext context) {
        AppUser appUserByEmail = userService.getUserByEmail(appUser.getEmail());
        if (appUserByEmail == null) {
            return false;
        } else {
            return BCrypt.checkpw(appUser.getPassword(), appUserByEmail.getPassword());
        }
    }
}