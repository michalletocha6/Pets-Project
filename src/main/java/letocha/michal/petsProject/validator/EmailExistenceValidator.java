package letocha.michal.petsProject.validator;

import letocha.michal.petsProject.entity.User;
import letocha.michal.petsProject.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Iterator;
import java.util.List;

public class EmailExistenceValidator implements ConstraintValidator<EmailExistence, String> {
    private final UserService userService;

    public EmailExistenceValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(EmailExistence constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<User> allUsers = userService.getAllUsers();
        Iterator<User> iterator = allUsers.iterator();

        if (!allUsers.isEmpty()) {
            while (iterator.hasNext()) {
                if (iterator.next().getEmail().equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}