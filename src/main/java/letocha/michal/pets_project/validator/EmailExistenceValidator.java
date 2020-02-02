package letocha.michal.pets_project.validator;

import letocha.michal.pets_project.entity.User;
import letocha.michal.pets_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Iterator;
import java.util.List;

public class EmailExistenceValidator implements ConstraintValidator<EmailExistence, String> {
    @Autowired
    private UserService userService;

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

    public EmailExistenceValidator() {
    }
}