package letocha.michal.pets_project.validator;

import letocha.michal.pets_project.entity.User;
import letocha.michal.pets_project.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailExistenceValidator implements ConstraintValidator<EmailExistence, String> {
    private final UserService userService;

    public EmailExistenceValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<User> allUsers = userService.getAllUsers();

        for (User user : allUsers) {
            if (user.getEmail().equals(value)) {
                return false;
            }
        }
        return true;
    }
}
